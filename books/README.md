## Learn TLA ([link](https://learntla.com))

*  `<< x_1, x_2, ..., x_n >> = [1 |-> x_1, 2 |-> x_2, ..., n |-> x_n]`
* `[X -> Y]` is the set of all possible mappings from `X` to `Y`

```tlaplus
IsComm(Op(_, _), x, y) == Op(x, y) = Op(y, x)

Rev2(xs) == IF Len(xs) = 2 THEN << xs[2], xs[1] >> ELSE xs

CoDomain(xs) == { xs[i] : i \in DOMAIN xs }

ContainsDobules(s1, s2) == { x * 2 : x \in s1 } \subseteq s2

InSetSeq(e, sets) == { s \in CoDomain(sets) : e \in s } /= {}
\* This is much cleaner and is from the book
\* InSetSeq(e, sets) == e \in UNION CoDomain(sets)

Subs2(xs) == { {x, y} : x \in xs /\ y \in xs }
\* The book gives this: Op(S) == { subset \in SUBSET S : Cardinality(subset) = 2 }

SumsToZero(xs, n) == \E zs \in SUBSET xs :
                        /\ Cardinality(zs) = n  
                        /\ Sum(zs) = 0

Commutes(op(_, _), xs) == \A x \in S, y \in S : op(x, y) = op(y, x)

Max(xs) == CHOOSE x \in xs : \A y \in xs : x >= y 

TwinPrime(x) == 
    /\ IsPrime(x) 
    /\ \/ IsPrime(x-2)
       \/ IsPrime(x+2)

LargestTwin(xs) == CHOOSE x \in xs:
                    /\ TwinPrime(x)
                    /\ \A y \in xs: 
                        TwinPrime(y) => y <= x

MaxProfit(prices) == { <<t1, t2>> : { t1 \in DOMAIN prices }

```

## Index 
[Functional Programming in Scala](./fpscala)