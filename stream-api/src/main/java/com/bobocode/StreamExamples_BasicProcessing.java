package com.bobocode;


import com.bobocode.data.Accounts;
import com.bobocode.model.Account;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples_BasicProcessing {
    public static void main(String[] args) {
        List<Account> accounts = Accounts.getAccountList(10);

        // Stream is not a collection, it's a way of processing data in pipelines
        // Stream does not provide a storage for data, but you can create a stream on top of some data source, like
        // a collection (however, it does not modify the collection)
        Stream<Account> accountStream = accounts.stream();

        // You can also create a stream using its factory methods
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        IntStream intStream;

        // Processing elements, method forEach() receives Consumer<Account>. This consumer process (consume) each
        // element of the stream
        System.out.println("Print email for each account: ");

        // internal iteration (declarative)
        Consumer<Account> printer = account -> System.out.println(account.getEmail());
        accounts.stream().forEach(printer);

        //external iteration (imperative)
        for (Account a: accounts){
            printer.accept(a);
        }

    }
}
