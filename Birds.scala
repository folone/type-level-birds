object Birds {

  // I combinator - identity bird / idion bird
  type Idiot = {
    type Apply[A] = A
  }
  val id: Idiot#Apply[List[Int]] = Nil

  // K combinator - kestrel - const. Corresponds to encoding of true in the lambda calculus.
  type Kestrel[A] = {
    type Apply[B] = A
  }
  val kestrel: Kestrel[List[Int]]#Apply[List[String]] = Nil

  // B combinator, function composition.
  type Bluebird[F[_], G[_]] = {
    type Apply[A] = F[G[A]]
  }
  val bluebird: Bluebird[List, List]#Apply[Int] = Nil

  // C combinator - cardinal - flip.
  type Cardinal[F[_,_]] = {
    type Apply[A,B] = F[B,A]
  }
  val cardinal: Cardinal[Map]#Apply[String, Int] = Map.empty

  // A combinator - apply/applicator, ($)
  type Applicator[F[_]] = {
    type Apply[A] = F[A]
  }
  val applicator: Applicator[List]#Apply[Int] = Nil

  // Psi combinator- psi bird, on.
  type Psi[P[_,_], F[_]] = { 
    type Apply[A, B] = P[F[A], F[B]]
  }
  val psi: Psi[Map, List]#Apply[Int, String] = Map.empty

  // B3 combinator - becard.
  type Becard[F[_], G[_], H[_]] = {
    type Apply[A] = F[G[H[A]]]
  }
  val becard: Becard[List,Set,List]#Apply[Int] = Nil

  // B1 combinator - blackbird
  type Blackbird[F[_], G[_,_]] = {
    type Apply[A,B] = F[G[A,B]]
  }
  val blackbird: Blackbird[List,Either]#Apply[Int,String] = Nil

  // B' combinator - bluebird prime.
  type BluebirdPrime[F[_,_],G[_]] = {
    type Apply[A,B] = F[A,G[B]]
  }
  val bluebirdPrime: BluebirdPrime[Map,List]#Apply[Int,String] = Map.empty

  //  B2 combinator - bunting.
  type Bunting[F[_], G[_,_,_]] = {
    type Apply[A,B,C] = F[G[A,B,C]]
  }
  val bunting: Bunting[List, CanBuildFrom]#Apply[List[String], Int, Set[String]] = Nil

}
