public class TransportBookingService {

    private DistanceService distanceService;
    private DriverService driverService;
    private PaymentService paymentService;

    public TransportBookingService(
            DistanceService distanceService,
            DriverService driverService,
            PaymentService paymentService) {

        this.distanceService = distanceService;
        this.driverService = driverService;
        this.paymentService = paymentService;
    }

    public void book(TripRequest request) {

        System.out.println("=== Transport Booking ===");

        double distance = distanceService.calculate(request.from, request.to);
        System.out.println("DistanceKm=" + distance);

        String driverId = driverService.allocateDriver(request);
        System.out.println("Driver=" + driverId);

        double fare = distance * 15; // pricing rule

        String txnId = paymentService.pay(fare);
        System.out.println("Payment=PAID txn=" + txnId);

        System.out.println("RECEIPT: R-501 | fare=" + String.format("%.2f", fare));
    }
}