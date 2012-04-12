package info.folone.birds.test

import info.folone.birds.Birds._
import org.specs2._
import scala.collection.generic._

class BirdsSpec extends Specification {
  def is =
    "This is a specification to check our birds types"   ^
                                                        p^
    "Idiot should"                                       ^
      "produce expected type"                        ! id^
                                                        p^
    "Kestrel should"                                     ^
      "produce expected type"                        !  k^
                                                        p^
    "Bluebird should"                                    ^
      "produce expected type"                        !  b^
                                                        p^
    "Cardinal should"                                    ^
      "produce expected type"                        !  c^
                                                        p^
    "Applicator should"                                  ^
      "produce expected type"                        ! ap^
                                                        p^
    "Psi should"                                         ^
      "produce expected type"                        ! ps^
                                                        p^
    "Becard should"                                      ^
      "produce expected type"                        ! b3^
                                                        p^
    "Blackbird should"                                   ^
      "produce expected type"                        ! bb^
                                                        p^
    "Bunting should"                                     ^
      "produce expected type"                        ! b2^
                                                        p^
    "Bluebird' should"                                   ^
      "produce expected type"                        ! bp^
                                                        p^
    "Cardinal' should"                                   ^
      "produce expected type"                        ! cp^
                                                        p^
    "Finch should"                                       ^
      "produce expected type"                        !  f^
                                                        p^
    "Why should"                                         ^
      "produce expected type"                        !  w^
                                                       end
  def id = (Nil: Idiot#Apply[List[Int]]) mustEqual(List[Int]())
  def k  = (Nil: Kestrel[List[Int]]#Apply[List[String]]) mustEqual(List[Int]())
  def b  = (Nil: Bluebird[List]#Apply[List]#Apply[Int]) mustEqual(List[List[Int]]())
  def c  = (Map.empty: Cardinal[Map]#Apply[String]#Apply[Int])
    .mustEqual(Map.empty[Int, String])
  def ap = (Nil: Applicator[List]#Apply[Int]) mustEqual(List[Int]())
  def ps = (Map.empty: Psi[Map]#Apply[List]#Apply[Int]#Apply[String])
    .mustEqual(Map.empty[List[Int], List[String]])
  def b3 = (Nil: Becard[List]#Apply[Set]#Apply[List]#Apply[Int])
    .mustEqual(List[Set[List[Int]]]())
  def bb = (Nil: Blackbird[List]#Apply[Either]#Apply[Int]#Apply[String])
    .mustEqual(List[Either[Int, String]]())
  def b2 =
    (Nil: Bunting[List]#Apply[CanBuildFrom]#Apply[List[String]]
     #Apply[Int]#Apply[Set[String]])
      .mustEqual(List[CanBuildFrom[List[String],Int,Set[String]]]())
  def bp = (Map.empty: BluebirdPrime[Map]#Apply[List]#Apply[Int]#Apply[String])
    .mustEqual(Map.empty[Int, List[String]])
  def cp = (Map.empty: CardinalPrime[Map]#Apply[List]#Apply[Int]#Apply[String])
    .mustEqual(Map.empty[List[String],Int])
  def f  = (Map.empty: Finch[Int]#Apply[String]#Apply[Map]) mustEqual(Map.empty[Int,String])
  def w  = (Nil: Why[List]#Apply) mustEqual(List[Why[List]]())
}
