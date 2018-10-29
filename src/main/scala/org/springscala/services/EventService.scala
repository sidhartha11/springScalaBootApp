package org.springscala.services

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import org.springscala.repositories.EventResponseRepository
import org.springscala.entity.EventResponse
import java.util.List
import java.lang.Iterable
import java.util.Optional

import org.springscala.utilities.Geoutils._



//import org.springframework.security.access.prepost.PreAuthorize
//import org.springframework.security.access.prepost.PostAuthorize

@Service
class EventService(@Autowired private val eventResponseRepository: EventResponseRepository) {

  def listEventResponse(): Iterable[EventResponse] = {
    eventResponseRepository.findAll
  }

  def getEventResponse(id: Long): Optional[EventResponse] = {
    emit(">>getEventResponse:" + id,true)
    eventResponseRepository.findById(id)
  }

  def createEventResponse(eventResponse: EventResponse): Long = {
    eventResponseRepository.save(eventResponse)
    eventResponse.id
  }
  
    def updateEventResponse(eventResponse: EventResponse): Long = {
    eventResponseRepository.save(eventResponse)
    eventResponse.id
  }
  
   def deleteEventResponse(eventResponse: EventResponse): Unit = {
    eventResponseRepository.delete(eventResponse)
  }

}