package org.springscala.controllers

import java.lang.Iterable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springscala.entity.{Users,EventResponse,EventRequest}
import org.springscala.services.UserService
import org.springscala.services.EventService

import javax.sql.DataSource
import org.springframework.http.HttpStatus
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.RequestBody
//import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.PathVariable

import org.springscala.utilities.Geoutils._
import org.springframework.web.bind.annotation.DeleteMapping

@RestController
@RequestMapping(path = Array("/api"))
class UserController(@Autowired private val eventService: EventService,@Autowired private val userService: UserService, @Autowired private val dataSource: DataSource) {

  def myName = this.getClass.getName

  @GetMapping(path = Array("/users"))
  def getAllUsers(): Iterable[Users] = {
    emit(myName + ">entered getAllUsers", true)
    userService.listUsers
  }

  @GetMapping(path = Array("/users/{id}"))
  def getUser(@PathVariable id: Long): ResponseEntity[Users] = {
    emit(myName + ">entered getUser", true)
    new ResponseEntity(userService.getUser(id).get, new HttpHeaders, HttpStatus.CREATED)
    //    userService.getUser(id).get
  }

  @PostMapping(path = Array("/users"))
  def createUser(@RequestBody users: Users): ResponseEntity[Long] = {
    emit(myName + ">entered createUser", true)
    val nuser = new Users
    nuser.setEnabled(users.getEnabled())
    nuser.setUsername(users.getUsername())
    nuser.setPassword(users.getPassword())
    val id = userService.createUser(nuser)

    new ResponseEntity(id, new HttpHeaders, HttpStatus.CREATED)
  }

  @PostMapping(path = Array("/update"))
  def updateUser(@RequestBody users: Users): ResponseEntity[Long] = {
    emit(myName + ">entered updateUser", true)
    println("updating " + users)
    val id = userService.updateUser(users)

    new ResponseEntity(id, new HttpHeaders, HttpStatus.CREATED)
  }

  @PostMapping(path = Array("/delete"))
  def deleteUser(@RequestBody users: Users): ResponseEntity[Long] = {
    emit(myName + ">entered deleteUser", true)
    val id = users.getId()
    userService.deleteUser(users)
    new ResponseEntity(id, new HttpHeaders, HttpStatus.CREATED)
  }
  /**
   *  EVENT PROCESSING SECTION
   */
  @GetMapping(path = Array("/eventrequest/{id}"))
  def getEventRequest(@PathVariable id: Long): ResponseEntity[EventResponse] = {
    emit(myName + ">entered getEventRequest:" + id, true)
    new ResponseEntity(eventService.getEventResponse(id).get, new HttpHeaders, HttpStatus.CREATED)
    //    userService.getUser(id).get
  }
  
    @PostMapping(path = Array("/createevent"))
  def createEvent(@RequestBody event: EventResponse): ResponseEntity[Long] = {
    emit(myName + ">entered event", true)
    val newEvent = new EventResponse
    newEvent.setEvent(event.getEvent())

    val id = eventService.createEventResponse(newEvent)

    new ResponseEntity(id, new HttpHeaders, HttpStatus.CREATED)
  }

  @PostMapping(path = Array("/updateevent"))
  def updateUser(@RequestBody event: EventResponse): ResponseEntity[Long] = {
    emit(myName + ">entered updateevent", true)
    println("updating " + event)
    val id = eventService.updateEventResponse(event)

    new ResponseEntity(id, new HttpHeaders, HttpStatus.CREATED)
  }

}