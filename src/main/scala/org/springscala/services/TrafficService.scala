package org.springscala.services

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import org.springscala.repositories.TrafficServiceRepository
import org.springscala.entity.TrafficResponse
import org.springscala.entity.TrafficRequest

import java.util.List
import java.lang.Iterable
import java.util.Optional

import org.springscala.utilities.Geoutils._



//import org.springframework.security.access.prepost.PreAuthorize
//import org.springframework.security.access.prepost.PostAuthorize

@Service
class TrafficService(@Autowired private val trafficServiceRepository: TrafficServiceRepository) {

  def listTrafficRequest(): Iterable[TrafficRequest] = {
    trafficServiceRepository.findAll
  }

  def getTrafficRequest(id: Long): Optional[TrafficRequest] = {
    emit(">>getTrafficRequest:" + id,true)
    trafficServiceRepository.findById(id)
  }

  def createTrafficRequest(trafficRequest: TrafficRequest): Long = {
    trafficServiceRepository.save(trafficRequest)
    trafficRequest.id
  }
  
    def updateTrafficRequest(trafficRequest: TrafficRequest): Long = {
    trafficServiceRepository.save(trafficRequest)
    trafficRequest.id
  }
  
   def deleteTrafficRequest(trafficRequest: TrafficRequest): Unit = {
    trafficServiceRepository.delete(trafficRequest)
  }
   
  def getRoutRandomResponse(request: TrafficRequest): Option[TrafficResponse] = {
    /**
     * first crete a random number between 0 and 3 
     * 0 = no route found 
     * 1 = good route found 
     * 2 = subpar route found 
     * 3 = perfect route found
     */
    
    val r = scala.util.Random
    r.setSeed(System.currentTimeMillis())
    r.nextInt(4) match {
      case 0 => Some(TrafficResponse(request, "no route"))
      case 1 => Some(TrafficResponse(request, "good route"))
      case 2 => Some(TrafficResponse(request, "subpar route"))
      case 3 => Some(TrafficResponse(request, "perfect route"))
      case _ => None 
    }
  }

}