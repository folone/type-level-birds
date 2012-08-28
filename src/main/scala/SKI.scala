package info.folone.birds

/**
 * @see: http://apocalisp.wordpress.com/2011/01/13/simple-ski-combinator-calculus-in-scalas-type-system/
 */
object SKI {
  trait λ { type ap[_<:λ]<:λ }
  type I = λ{type ap[X<:λ] = X }
  type K = λ{type ap[X<:λ] = λ{type ap[Y<:λ] = X }}
  type S = λ{type ap[X<:λ] = λ{type ap[Y<:λ] = λ{type ap[Z<:λ] = X#ap[Z]#ap[Y#ap[Z]] }}}

  type U = S#ap[I]#ap[I]
}
