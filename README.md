ServiceMix JBI Payment Service Example
======================================

Overview
--------

This example shows 2 JBI components working with a Camel file batch splitter all deployed as 3 separate OSGi bundles
and communicating between bundles through the ServiceMix NMR component. This shows an example of one way to convert
an JBI application to OSGi and leverage Apache Camel.

Building
--------

Using Apache Maven 2.2.1 or 3.x in this projects root directory
> mvn clean install

Running
-------

Tested with ServiceMix 4.2.0-fuse-02-00, 4.3.1-fuse-01-22, and 4.4.0-fuse-00-43 ([download](http://fusesource.com/downloads/))

Start ServiceMix (`bin/servicemix`), and from the ServiceMix console execute the following

    karaf@root> osgi:install --start mvn:com.example.fuse/payment-service-se/1.0
    karaf@root> osgi:install --start mvn:com.example.fuse/payment-service-bc/1.0

At this point the SOAP/HTTP front-end is installed and started, so you can test by pointing your favorite SOAP
test toole (e.g. SoapUI) at `http://localhost:9090/cxf/paymentService?WSDL`

You can also look at the ServiceMix log fails for this example by doing at

    karaf@root> log:display | grep Payment

You can also view the JBI commonents by running

    karaf@root> jbi:list
    karaf@root> nmr:list

To install and start the Camel based File Batch Splitter

    karaf@root> osgi:install --start mvn:com.example.fuse/payment-service-batch/1.0

In the log (`karaf@root> log:display`) you will start to see entries showing it splitting a test file every 5 seconds.
To stop the Camel route, execute

    karaf@root> osgi:stop <bundle id for payment-service-batch>

ServiceMix would have printed out the bundle id after you installed that bundle. You can also to an `osgi:list` to find
the bundle id.
