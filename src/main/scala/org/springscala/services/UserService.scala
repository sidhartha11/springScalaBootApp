package org.springscala.services

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import org.springscala.repositories.UserRepository
import org.springscala.entity.Users
import java.util.List
import java.lang.Iterable
import java.util.Optional


//import org.springframework.security.access.prepost.PreAuthorize
//import org.springframework.security.access.prepost.PostAuthorize

@Service
class UserService(@Autowired private val userRepository: UserRepository) {

  def listUsers(): Iterable[Users] = {
    userRepository.findAll
  }

  def getUser(id: Long): Optional[Users] = {
    userRepository.findById(id)
  }

  def createUser(users: Users): Long = {
    userRepository.save(users)
    users.id
  }
  
    def updateUser(users: Users): Long = {
    userRepository.save(users)
    users.id
  }
  
   def deleteUser(users: Users): Unit = {
    userRepository.delete(users)
  }

}