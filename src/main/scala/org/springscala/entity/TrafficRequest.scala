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
import javax.persistence.Temporal
import javax.persistence.TemporalType


@Entity
class TrafficRequest extends Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @BeanProperty
  var id: Long = _
  
  @BeanProperty
  @Column(name = "destination")
  var destination: String = _
 
  @BeanProperty
  @Column(name = "arrivalTime" , columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  var arrivalTime: Date = _
  
  override def toString = "TrafficRequest [id:%d, destination:%s, arrivalTime:%s]".format(id,destination,arrivalTime)
}