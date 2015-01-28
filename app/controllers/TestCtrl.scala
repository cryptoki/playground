package controllers

import play.api.mvc.{Action, Controller}

object TestCtrl extends Controller {
  def helloWorld = Action { 
    request => {
      println(request.queryString)
      Ok
    }
  }
}
