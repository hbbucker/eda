package br.com.bucker.usecase;

public interface UseCase<I, O> {
    O execute(I input);
}
