package br.com.rcp.hearthstone.mapper

/*
 * Interface for model mappers.
 * @param <I> the `in` type
 * @param <O> the `out` type
 */
interface Mapper<I, O> {
    fun map(type: I): O
}
