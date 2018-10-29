package org.springscala.repositories

import org.springframework.data.repository.CrudRepository
import org.springscala.entity.EventResponse
import org.springframework.stereotype.Repository
import java.lang.Long






@Repository
trait EventResponseRepository extends CrudRepository[EventResponse, Long] {

  def findEventResponseByEvent(event: String): EventResponse

}

