# gnosis
My Knowledgebase

# Questions

* Are explicit & restrictive models of programming that are closer to mathematical proofs pragmatical?
* Why so few people are into FP?
* How to choose a programming language to use in your business project?
* Is OOP any good? Especially in concurrent world.
    * Is OOP more like Literature (organic, imprecise) while FP is more like Maths (analytical, rigid)?
* Should we just relax and do whatever works? Is there actual value in correctness and soundness? 
* Is it responsible to use pure FP in business if you know how hard it is to find people even a little bit interested in any FP at all? 
    * Obviously we can do that for our personal projects / business we own.
    * I personally wouldn't do it even in a position of a CTO.
* Is non pure FP actually as useless as Meijer says? Yes we do need to embrace the fact that impure programs are completely side-effecting. But we are still reducing (not eliminating, sure) the space for errors and simplify our reasoning a bit. I.e. I'd argue it's still better than traditional OOP.
* Am I just stupid? 
    * Well, why is it even a question?
* FP in the small -> pure FP (with IO) -> pure FP (with tagless final + interpreters, i.e. abstracting over effects)
* Typeclasses are kinda correspondent to ECS? 
    * Typeclass = component's api
    * datatype = entity + component's data
    * instance = adding component to an entity
    * constrained function = a system for respective components

# TODO

- [ ] Read asnd annotate all the papers in the world
- [ ] Study fs2 in detail
- [ ] Study cats-effect in detail
- [ ] Study tagless final more, much more
- [ ] Learn Rust
- [ ] Write IO in Rust? Is it even possible with all the lifetime control stuff?
- [ ] Learn Idris
- [ ] Generate all inhabitants of any 'small' type with shapeless
- [ ] Go here http://nercury.github.io/rust/opengl/tutorial/2018/02/08/opengl-in-rust-from-scratch-00-setup.html
- [ ] Write a mastodon back-end in rust? Who the hell writes RoR apps, damit.

# Notes

* From https://www.youtube.com/watch?v=CQxviYlAKaY 
    * Internal messages are bad, only evolve an actor from external messages. E.g. instead of firing up an internal ticking timer externalize the source of ticking. Makes actor more isolated and decoupled from the timing logic.
    * Careful with capturing internals and leaking them through closures to other threads. E.g. doing something to private state in a future callback.
    * Async blocking, `Future#pipeTo(ActorRef)`, `become` to wait for the result, then `become` back.
    * Evolve like in Erlang, through passing immutable state to a new state.
    * No I/O in actors, no effectful reads (say current time). As pure as possible, right.
    * Mocks & stubs are signs of tight coupling. 
