package org.springscala.repositories

import org.springframework.data.repository.CrudRepository
import org.springscala.entity.TrafficResponse
import org.springscala.entity.TrafficRequest

import org.springframework.stereotype.Repository
import java.lang.Long

@Repository
trait TrafficServiceRepository extends CrudRepository[TrafficRequest, Long] {
  def findTrafficRequestByDestination(destination: String): TrafficRequest
}

