package com.product.marcus.nearbygrocery;

import com.product.marcus.nearbygrocery.models.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcus on 8/16/2017.
 */

public class MockModelsFactory {
    public static Result createResult() {
        return new Result();
    }

    public static List<Result> createListOfResults(int count) {
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            results.add(new Result());
        }
        return results;
    }
}
