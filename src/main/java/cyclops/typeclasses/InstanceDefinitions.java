package cyclops.typeclasses;

import com.aol.cyclops2.hkt.Higher;
import cyclops.control.Maybe;
import cyclops.control.Xor;
import cyclops.function.Monoid;
import cyclops.typeclasses.comonad.Comonad;
import cyclops.typeclasses.foldable.Foldable;
import cyclops.typeclasses.foldable.Unfoldable;
import cyclops.typeclasses.functions.SemigroupK;
import cyclops.typeclasses.functor.BiFunctor;
import cyclops.typeclasses.functor.ContravariantFunctor;
import cyclops.typeclasses.functor.Functor;
import cyclops.typeclasses.functor.ProFunctor;
import cyclops.typeclasses.monad.*;

import java.util.function.Function;

/**
 * Created by johnmcclean on 28/06/2017.
 */
public interface InstanceDefinitions<W> {



    default Eq<W> eq(){
        return new Eq<W>(){};
    }

    <T,R>Functor<W> functor();
    <T> Pure<W> unit();
    <T,R> Applicative<W> applicative();
    <T,R> Monad<W> monad();
    <T,R> Maybe<MonadZero<W>> monadZero();
    <T> Maybe<MonadPlus<W>> monadPlus();
    <T> MonadRec<W> monadRec();
    <T> Foldable<W> foldable();
    <C2,T> Traverse<W> traverse();


    default <T> Maybe<ContravariantFunctor<W>> contravariantFunctor(){
        return Maybe.none();
    }
    default <T> Maybe<ProFunctor<W>> profunctor(){
        return Maybe.none();
    }
    default <T,E> Maybe<ApplicativeError<W,E>> applicativeError(){
        return Maybe.none();
    }


    <T> Maybe<MonadPlus<W>> monadPlus(Monoid<Higher<W,T>> m);



    <T> Maybe<Comonad<W>> comonad();

    default  <T> Maybe<Unfoldable<W>> unfoldable(){
        return Maybe.none();
    }



    default Show<W> show(){
        return new Show<W>(){};
    }

}