interface IService{
    void service();
}
class IServiceImpl implements IService{

    @Override
    public void service() {
        System.out.println("实现方式1");
    }
}
class MyServiceImpl implements IService {

    @Override
    public void service() {
        System.out.println("实现方式2");
    }
}
public class InterfaceDemo {

    public void invokeService(IService service){
        service.service();
    }
    public static void main(String[] args) {
        IService service = new IServiceImpl();
        InterfaceDemo demo = new InterfaceDemo();
        demo.invokeService(service);
    }
}
