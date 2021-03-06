package org.springscala.entity

import scala.beans.BeanProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import java.lang.Long
import javax.persistence.OneToMany
import java.util.Set
import java.io.Serializable
import javax.persistence.GenerationType
import javax.persistence.Column

import java.util.{Date}

case class Event(body: String)
// (ticket: Int, event: Event)
@Entity
class EventResponse extends Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @BeanProperty
  var id: Long = _
  
  @BeanProperty
  @Column(name = "event")
  var event: String = _
  
  @BeanProperty
  @Column(name = "location")
  var location: String = _
  
  @BeanProperty
  @Column(name = "timeStamp")
  var timeStamp: String = _
  
  
  override def toString = "id:%d, event:%s, location:%s".format(id,event,location,timeStamp)

}