package br.com.rcp.data.mapper

/*
 * Interface for model mappers.
 * @param <I> the `in` type
 * @param <O> the `out` type
 */
interface Mapper<I, O> {
    fun map(type: I): O
}
