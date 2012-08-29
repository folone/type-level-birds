package info.folone.birds.test

import info.folone.birds.Birds._
import org.specs2._
import org.scalacheck._
import scala.collection.generic._

class BirdsSpec extends Specification with ScalaCheck {
  def typed[T](t : => T) = true
  def is =
    "This is a specification to check our birds types"                 ^
                                                                      p^
    "Idiot should"                                                     ^
      "produce expected type"                                      ! id^
                                                                      p^
    "Kestrel should"                                                   ^
      "produce expected type"                                      !  k^
                                                                      p^
    "Bluebird should"                                                  ^
      "produce expected type"                                      !  b^
                                                                      p^
    "Cardinal should"                                                  ^
      "produce expected type"                                      !  c^
                                                                      p^
    "Applicator should"                                                ^
      "produce expected type"                                      ! ap^
                                                                      p^
    "Psi should"                                                       ^
      "produce expected type"                                      ! ps^
                                                                      p^
    "Becard should"                                                    ^
      "produce expected type"                                      ! b3^
                                                                      p^
    "Blackbird should"                                                 ^
      "produce expected type"                                      ! bb^
                                                                      p^
    "Bunting should"                                                   ^
      "produce expected type"                                      ! b2^
                                                                      p^
    "Bluebird' should"                                                 ^
      "produce expected type"                                      ! bp^
                                                                      p^
    "Cardinal' should"                                                 ^
      "produce expected type"                                      ! cp^
                                                                      p^
    "Finch should"                                                     ^
      "produce expected type"                                      !  f^
                                                                      p^
    "Why should"                                                       ^
      "produce expected type"                                      !  w^
                                                                    end

  def id = checkProp {
    (lst: List[Int]) => typed[List[Int]](lst: Idiot#Apply[List[Int]]) must beTrue
  }
  def k  = checkProp {
    (lst: List[Int]) => typed[List[Int]](lst: Kestrel[List[Int]]#Apply[List[String]]) must beTrue
  }
  def b  = checkProp {
    (lst: List[List[Int]]) => typed[List[List[Int]]](lst: Bluebird[List]#Apply[List]#Apply[Int]) must beTrue
  }
  def c  = checkProp {
    (map: Map[Int, String]) => typed[Map[Int, String]](map: Cardinal[Map]#Apply[String]#Apply[Int]) must beTrue
  }
  def ap = checkProp {
    (lst: List[Int]) => typed[List[Int]](lst: Applicator[List]#Apply[Int]) must beTrue
  }
  def ps = checkProp {
    (map: Map[List[Int], List[String]]) => typed[Map[List[Int], List[String]]](map: Psi[Map]#Apply[List]#Apply[Int]#Apply[String]) must beTrue
  }
  def b3 = checkProp {
    (lst: List[Set[List[Int]]]) => typed[List[Set[List[Int]]]](lst: Becard[List]#Apply[Set]#Apply[List]#Apply[Int]) must beTrue
  }
  def bb = checkProp {
    (lst: List[Either[Int, String]]) => typed[List[Either[Int, String]]](lst: Blackbird[List]#Apply[Either]#Apply[Int]#Apply[String]) must beTrue
  }
  def b2 = typed[List[CanBuildFrom[List[String],Int,Set[String]]]](Nil: Bunting[List]#Apply[CanBuildFrom]#Apply[List[String]]#Apply[Int]#Apply[Set[String]]) must beTrue
  def bp = checkProp {
    (map: Map[Int, List[String]]) => typed[Map[Int, List[String]]](map: BluebirdPrime[Map]#Apply[List]#Apply[Int]#Apply[String]) must beTrue
  }
  def cp = checkProp {
    (map: Map[List[String], Int]) => typed[Map[List[String], Int]](map: CardinalPrime[Map]#Apply[List]#Apply[Int]#Apply[String]) must beTrue
  }
  def f  = checkProp {
    (map: Map[Int, String]) => typed[Map[Int, String]](map: Finch[Int]#Apply[String]#Apply[Map]) must beTrue
  }
  def w  = typed[List[Why[List]]](Nil: Why[List]#Apply) must beTrue
} 
