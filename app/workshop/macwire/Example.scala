package workshop.macwire

import com.softwaremill.macwire.MacwireMacros.wire
import workshop.macwire.loading.LoadingModule
import workshop.macwire.shunting.ShuntingModule
import workshop.macwire.station.StationModule

/**
 * http://di-in-scala.github.io
 * o access wire, you can either import the com.softwaremill.macwire.MacwireMacros object,
 * or extend the Macwire trait. For details on how to integrate MacWire into your project, see the GitHub page.
 * https://github.com/adamw/macwire
 */
//class PointSwitcher()
//class TrainCarCoupler()
//class TrainShunter(pointSwitcher: PointSwitcher, trainCarCoupler: TrainCarCoupler)
//
//class CraneController()
//class TrainLoader(craneController: CraneController, pointSwitcher: PointSwitcher)
//
//class TrainDispatch()
//class TrainStation(trainShunter: TrainShunter, trainLoader: TrainLoader, trainDispatch: TrainDispatch) {
//  def prepareAndDispatchNextTrain() = {
//    2
//  }
//}
//
//
//object TrainStation extends App {
//  lazy val pointSwitcher = wire[PointSwitcher]
//  lazy val trainCarCoupler = wire[TrainCarCoupler]
//  lazy val trainShunter = wire[TrainShunter]
//
//  lazy val craneController = wire[CraneController]
//  lazy val trainLoader = wire[TrainLoader]
//  def trainDispatch = wire[TrainDispatch]
//
//  lazy val trainStation = wire[TrainStation]
//
//  trainStation.prepareAndDispatchNextTrain()
//}
//


package shunting {
  class PointSwitcher()
  class TrainCarCoupler()
  class TrainShunter(pointSwitcher: PointSwitcher, trainCarCoupler: TrainCarCoupler)

  trait ShuntingModule {
    lazy val pointSwitcher = wire[PointSwitcher]
    lazy val trainCarCoupler = wire[TrainCarCoupler]
    lazy val trainShunter = wire[TrainShunter]
  }
}

package loading {

import workshop.macwire.shunting.PointSwitcher

class CraneController()
  class TrainLoader(craneController: CraneController, pointSwitcher: PointSwitcher)

  trait LoadingModule {
    lazy val craneController = wire[CraneController]
    lazy val trainLoader = wire[TrainLoader]

    // dependency of the module
    def pointSwitcher: PointSwitcher
  }
}

package station {
import workshop.macwire.loading.TrainLoader
import workshop.macwire.shunting.TrainShunter

  class TrainDispatch()

  class TrainStation(trainShunter: TrainShunter, trainLoader: TrainLoader, trainDispatch: TrainDispatch) {
    def prepareAndDispatchNextTrain() = { 2 }
  }

  trait StationModule {
    lazy val trainDispatch = wire[TrainDispatch]

    lazy val trainStation = wire[TrainStation]

    // dependencies of the module
    def trainShunter: TrainShunter
    def trainLoader: TrainLoader
  }

}


object TrainStation extends App {
  val modules = new ShuntingModule
    with LoadingModule
    with StationModule

  modules.trainStation.prepareAndDispatchNextTrain()
}