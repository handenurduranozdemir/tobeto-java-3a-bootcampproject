package com.tobeto.bootcampProject.core.results;

public class SuccessResult extends Result {
    public SuccessResult(String message)
    {
        super(true, message);
    }

    public SuccessResult()
    {
        super(true);
    }
}
