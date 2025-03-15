package com.pm.billingservice.grpc;

import billing.BillingResponse;
import billing.BillingServiceGrpc.BillingServiceImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class BillingGrpcService extends BillingServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(BillingGrpcService.class);

    //This is automatically generated when we compile, that is why we need to override to add our own logic
    @Override
    public void createBillingAccount(billing.BillingRequest billingRequest,
            StreamObserver<billing.BillingResponse> responseObserver) {

        log.info("createBillingAccount request received {}", billingRequest.toString());

        //Business logic - stuff like save to database, perform calculations, etc

        BillingResponse response = BillingResponse.newBuilder()
                .setAccountId("12345")
                .setStatus("ACTIVE")
                .build();

        responseObserver.onNext(response); //used to send a response from grpcservice back to client (in this case - patientservice)
        responseObserver.onCompleted(); //response is completed and just end
    //Can send multiple responses by using .onNext() before completing.

    }

}
