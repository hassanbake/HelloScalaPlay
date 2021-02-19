package controllers

import javax.inject._
import play.api.mvc._

@Singleton
class Users @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def addUser() = Action { implicit request =>
    val body = request.body

    body.asFormUrlEncoded match {
      case Some(map) =>
        //persist user informatio
        Ok(s"The user of name `${map("name").head}` and age `${map("age").head}` has been created\n")
      case None =>
        BadRequest("Unknown body format")
    }
  }
}