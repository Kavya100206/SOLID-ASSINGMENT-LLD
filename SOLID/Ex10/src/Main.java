public class Main {
    public static void main(String[] args) {

        GeoPoint from = new GeoPoint(12.9, 77.5);
        GeoPoint to = new GeoPoint(12.95, 77.55);

        TripRequest request = new TripRequest("23BCS1007", from, to);

        DistanceService distanceService = new DistanceCalculator();
        DriverService driverService = new DriverAllocator();
        PaymentService paymentService = new PaymentGateway();

        TransportBookingService bookingService =
                new TransportBookingService(
                        distanceService,
                        driverService,
                        paymentService);

        bookingService.book(request);
    }
}