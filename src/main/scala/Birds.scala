package info.folone.birds

object Birds {

  // I combinator - identity bird / idiot bird
  type Idiot = {
    type Apply[A] = A
  }

  // K combinator - kestrel - const. Corresponds to encoding of true in the lambda calculus.
  type Kestrel[A] = {
    type Apply[B] = A
  }

  // B combinator, function composition.
  type Bluebird[G[_]] = {
    type Apply[F[_]] = {
      type Apply[A] = F[G[A]]
    }
  }

  // C combinator - cardinal - flip.
  type Cardinal[F[_,_]] = {
    type Apply[A] = {
      type Apply[B] = F[B,A]
    }
  }

  // A combinator - apply/applicator, ($)
  type Applicator[F[_]] = {
    type Apply[A] = F[A]
  }

  // Psi combinator- psi bird, on.
  type Psi[G[_,_]] = { 
    type Apply[F[_]] = {
      type Apply[A] = {
        type Apply[B] = G[F[A], F[B]]
      }
    }
  }

  // B3 combinator - becard.
  type Becard[F[_]] = {
    type Apply[G[_]] = {
      type Apply[H[_]] = {
        type Apply[A] = F[G[H[A]]]
      }
    }
  }

  // B1 combinator - blackbird
  type Blackbird[F[_]] = {
    type Apply[G[_,_]] = {
      type Apply[A] =  {
        type Apply[B] = F[G[A,B]]
      }
    }
  }

  // B' combinator - bluebird prime.
  type BluebirdPrime[F[_,_]] = {
    type Apply[G[_]] = {
      type Apply[A] = {
        type Apply[B] = F[A,G[B]]
      }
    }
  }

  //  B2 combinator - bunting.
  type Bunting[F[_]] = {
    type Apply[G[_,_,_]] = {
      type Apply[A] = {
        type Apply[B] = {
          type Apply[C] = F[G[A,B,C]]
        }
      }
    }
  }

  // C' combinator - no name.
  type CardinalPrime[F[_,_]] = {
    type Apply[G[_]] = {
      type Apply[A] = {
        type Apply[B] = F[G[B],A]
      }
    }
  }

  // C* combinator - cardinal once removed.
  type CardinalStar[F[_,_,_]] = {
    type Apply[A] = {
      type Apply[B] = {
        type Apply[C] = F[A,C,B]
      }
    }
  }
  var cardinalStar: CardinalStar[CanBuildFrom]#Apply[List[String]]#Apply[Int]#Apply[Set[String]] = _

  // C** combinator - cardinal twice removed.
  type CardinalStarStar[F[_,_,_,_]] = {
    type Apply[A] = {
      type Apply[B] = {
        type Apply[C] = {
          type Apply[D] = F[A,B,D,C]
        }
      }
    }
  }
  // TODO example

  // D1 combinator - dickcissel.
  type Dickcissel[F[_,_,_]] = {
    type Apply[A] = {
      type Apply[B] = {
        type Apply[G[_]] = {
          type Apply[C] = F[A,B,G[C]]
        }
      }
    }
  }
  // TODO example

  // D combinator - dove.
  type Dove[F[_,_]] = {
    type Apply[A] = {
      type Apply[G[_]] = {
        type Apply[B] = F[A,G[B]]
      }
    }
  }
  // TODO example

  // D2 combinator - dovekie.
  type Dovekie[F[_,_]] = {
    type Apply[G[_]] = {
      type Apply[A] = {
        type Apply[H[_]] = {
          type Apply[B] = F[G[A],H[B]]
        }
      }
    }
  }
  // TODO example

  // E combinator - eagle.
  type Eagle[F[_,_]] = {
    type Apply[A] = {
      type Apply[G[_,_]] = {
        type Apply[B] = {
          type Apply[C] = F[A,G[B,C]]
        }
      }
    }
  }
  // TODO example

  // E Combinator - bald eagle.
  // For alphabetical regularity it is somewhat misnamed here as eaglebald.
  type Eaglebald[F[_,_]] = {
    type Apply[G[_,_]] = {
      type Apply[A] = {
        type Apply[B] = {
          type Apply[H[_,_]] = {
            type Apply[C] = {
              type Apply[D] = F[G[A,B],H[C,D]]
            }
          }
        }
      }
    }
  }
  // TODO example

  // F combinator - finch.
  type Finch[A] = {
    type Apply[B] = {
      type Apply[F[_,_]] = F[A,B]
    }
  }
  val finch: Finch[Int]#Apply[String]#Apply[Map] = Map.empty

  // F* combinator - finch once removed.
  type FinchStar[F[_,_,_]] = {
    type Apply[A] = {
      type Apply[B] = {
        type Apply[C] = F[C,B,A]
      }
    }
  }

  // F** combinator - finch twice removed.
  type FinchStarStar[F[_,_,_,_]] = {
    type Apply[A] = {
      type Apply[B] = {
        type Apply[C] = {
          type Apply[D] = F[A,D,C,B]
        }
      }
    }
  }
  // TODO example

  // G combinator - goldfinch.
  type GoldFinch[F[_,_]] = {
    type Apply[G[_]] = {
      type Apply[A] = {
        type Apply[B] = F[B,G[A]]
      }
    }
  }
  // TODO example

  // H combinator - hummingbird.
  type Hummingbird[F[_,_,_]] = {
    type Apply[A] = {
      type Apply[B] = F[A,B,A]
    }
  }
  // TODO example

  // I* combinator - identity bird once removed
  //Alias of 'applicator'
  type IdStar[F[_]] = Applicator[F]

  // I** combinator - identity bird twice removed
  type IdStarStar[F[_,_]] = {
    type Apply[A] = {
      type Apply[B] = F[A,B]
    }
  }
  // TODO example

  // Alternative J combinator - this is the J combintor of Joy,
  // Rayward-Smith and Burton (see. Antoni Diller 'Compiling 
  // Functional Languages' page 104). It is not the J - jay 
  // combinator of the literature. 
  type Jalt[F[_]] = {
    type Apply[A] = {
      type Apply[B] = F[A]
    }
  }
  // TODO example

  // ' combinator - from Joy, Rayward-Smith and Burton.
  // See the comment to 'jalt'.
  type JaltPrime[F[_,_]] = {
    type Apply[A] = {
      type Apply[B] = {
        type Apply[C] = F[A,B]
      }
    }
  }
  // TODO example

  // This is the usual J combinator.
  type Jay[F[_,_]] = {
    type Apply[A] = {
      type Apply[B] = {
        type Apply[C] = F[A,F[C,B]]
      }
    }
  }

  // Ki - kite.
  // Corresponds to the encoding of false in the lambda calculus.
  // Dual to Kestrel
  type Kite[A] = {
    type Apply[B] = B
  }
  // TODO example

  // M combinator - mockingbird (Really?).
  type Mockingbird[F[_]] = {
    type Apply = F[F[_]]
  }
  val p: Mockingbird[List]#Apply = Nil

  // O combinator - owl.
  type Owl[F[_]] = {
    type Apply[G[_]] = G[F[G[_]]]
  }
  // TODO example

  // (Big) Phi combinator - phoenix - Haskell 'liftM2'.
  type Phoenix[F[_,_]] = {
    type Apply[G[_]] = {
      type Apply[H[_]] = {
        type Apply[A] = F[G[A],H[A]]
      }
    }
  }
  // TODO example

  // Q4 combinator - quacky bird.
  type Quacky[A] = {
    type Apply[F[_]] = {
      type Apply[G[_]] = G[F[A]]
    }
  }
  // TODO example

  // Q combinator - queer bird.
  //Peter Thiemann\'s Wash, reverse composition.
  type Queer[F[_]] = {
    type Apply[G[_]] = {
      type Apply[A] = G[F[A]]
    }
  }
  // TODO example

  // Q3 combinator - quirky bird.
  type Quirky[F[_]] = {
    type Apply[A] = {
      type Apply[G[_]] = G[F[A]]
    }
  }
  // TODO example

  // Q1 combinator - quixotic bird.
  type Quixotic[F[_]] = {
    type Apply[A] = {
      type Apply[G[_]] = F[G[A]]
    }
  }
  // TODO example

  // Q2 combinator - quizzical bird.
  type Quizzical[A] = {
    type Apply[F[_]] = {
      type Apply[G[_]] = F[G[A]]
    }
  }
  // TODO example

  // R combinator - robin.
  type Robin[A] = {
    type Apply[F[_,_]] = {
      type Apply[B] = F[B,A]
    }
  }
  // TODO example

  // R* combinator - robin once removed.
  type RobinStar[F[_,_,_]] = {
    type Apply[A] = {
      type Apply[B] = {
        type Apply[C] = F[B,C,A]
      }
    }
  }
  // TODO example

  // R* combinator - robin twice removed.
  type RobinStarStar[F[_,_,_,_]] = {
    type Apply[A,B,C,D] = F[A,C,D,B]
  }
  // TODO example

  // S combinator - starling.
  // Applicative <*> on functions.
  // Substitution
  type Starling[F[_,_]] = {
    type Apply[G[_]] = {
      type Apply[A] = F[A,G[A]]
    }
  }
  // TODO example

  // S' combinator - starling prime - Turner's big phi. 
  // liftA2 on functions.
  type StarlingPrime[F[_,_]] = {
    type Apply[G[_]] = {
      type Apply[H[_]] = {
        type Apply[A] = F[G[A],H[A]]
      }
    }
  }
  // TODO example

  // T combinator - thrush.
  // Peter Thiemann's Wash, reverse application.
  type Thrush[A] = {
    type Apply[F[_]] = F[A]
  }
  // TODO example

  // V combinator - vireo.
  type Vireo[A] = {
    type Apply[B] = {
      type Apply[F[_,_]] = F[A,B]
    }
  }
  // TODO example

  // V* combinator - vireo once removed.
  type VireoStar[F[_,_,_]] = {
    type Apply[A] = {
      type Apply[B] = {
        type Apply[C] = F[B,A,C]
      }
    }
  }
  // TODO example

  // V** combinator - vireo twice removed.
  type VireoStarStar[F[_,_,_,_]] = {
    type Apply[A] = {
      type Apply[B] = {
        type Apply[C,D] = {
          type Apply[D] = F[A,D,B,C]
        }
      }
    }
  }
  // TODO example

  // W combinator - warbler - elementary duplicator.
  type Warbler[F[_,_]] = {
    type Apply[A] = F[A,A]
  }
  // TODO example

  // W1 combinator - converse warbler.
  // 'warbler' with the arguments reversed.
  type Warbler1[A] = {
    type Apply[F[_,_]] = F[A,A]
  }
  // TODO example

  // W* combinator - warbler once removed.
  type WarblerStar[F[_,_,_]] = {
    type Apply[A] = {
      type Apply[B] = F[A,B,B]
    }
  }
  // TODO example

  // W** combinator - warbler twice removed.
  type WarblerStarStar[F[_,_,_,_]] = {
    type Apply[A] = {
      type Apply[B] = {
        type Apply[C] = F[A, B, C, C]
      }
    }
  }
  // TODO example

}
