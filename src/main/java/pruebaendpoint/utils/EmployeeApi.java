package pruebaendpoint.utils;

public class EmployeeApi {

    private EmployeeApi() {
        throw new IllegalStateException("Utility class");
    }
    public static String API_URL = "https://dummy.restapiexample.com/api/v1";
    public static String GET_ALL_EMPLOYEES = "/employees";
    public static String GET_EMPLOYEE = "/employee/%s";
    public static String CREATE_EMPLOYEE = "/create";
    public static String UPDATE_EMPLOYEE = "/update/%s";
    public static String DELETE_EMPLOYEE = "/delete/%s";
}
