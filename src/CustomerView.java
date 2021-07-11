import javax.sound.midi.SoundbankResource;

public class CustomerView {
    private CustomerList customerList = new CustomerList(10);
    public void enterMainMenu(){
        boolean loopFlag = true;
        do{
            System.out.println("------------------------------客户信息管理软件------------------------------");
            System.out.println();
            System.out.println("\t\t\t\t\t\t\t 1 添加客户  \t\t\t\t\t\t\t");
            System.out.println("\t\t\t\t\t\t\t 2 修改客户  \t\t\t\t\t\t\t");
            System.out.println("\t\t\t\t\t\t\t 3 删除客户  \t\t\t\t\t\t\t");
            System.out.println("\t\t\t\t\t\t\t 4 客户列表  \t\t\t\t\t\t\t");
            System.out.println("\t\t\t\t\t\t\t 5 退   出  \t\t\t\t\t\t\t");

            System.out.println();
            System.out.print("\t\t\t\t\t\t\t 请选择(1-5):");
            char menu = CMUtility.readMenuSelection();
            switch (menu){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.print("确认是否退出(Y/N):");
                    char choiceExit = CMUtility.readConfirmSelection();
                    if(choiceExit=='y'||choiceExit=='Y') loopFlag = false;
                    else loopFlag = true;
                    break;
            }
        }while (loopFlag);
    }

    private void addNewCustomer() {
        System.out.println("------------------------------添加客户------------------------------");
        System.out.print("姓名:");
        String name = CMUtility.readString(10);
        System.out.print("性别:");
        char gender = CMUtility.readChar('男');
        System.out.print("年龄:");
        int age = CMUtility.readInt(18);
        System.out.print("电话:");
        String phone = CMUtility.readString(11);
        System.out.print("邮箱:");
        String email = CMUtility.readString(20);
        Customer c = new Customer(name,gender,age,phone,email);
        boolean flag = customerList.addCustomer(c);
        if(flag)
            System.out.println("------------------------------添加完成---------------------------");
        else {
            System.out.println("人数已达上限，添加失败");
        }
    }

    private void modifyCustomer() {
        System.out.println("------------------------------修改客户------------------------------");
        Customer customer;
        int index;
        for (; ; ) {
            System.out.print("请选择待修改客户编号(-1)退出:");
            index = CMUtility.readInt();
            if (index == -1) return;
            customer = customerList.getCustomer(index - 1);
            if (customer == null) {
                System.out.println("无法找到指定客户！");
            } else {
                break;
            }
        }
        //开始修改
        // 如果用户输入了姓名，则返回用户输入的信息，如果用户没有输入，直接回车，则返回customer.getName()
        System.out.print("姓名(" + customer.getName() + "):");
        String name = CMUtility.readString(5, customer.getName());

        System.out.print("性别(" + customer.getGender() + "):");
        char gender = CMUtility.readChar(customer.getGender());

        System.out.print("年龄(" + customer.getAge() + "):");
        int age = CMUtility.readInt(customer.getAge());


        System.out.print("电话(" + customer.getPhone() + "):");
        String phone = CMUtility.readString(11, customer.getPhone());

        System.out.println("邮箱(" + customer.getEmail() + "):");
        String email = CMUtility.readString(20, customer.getEmail());
        Customer newCus = new Customer(name, gender, age, phone, email);
        boolean flag = customerList.replaceCustomer(index - 1, newCus);
        if (flag)
            System.out.println("------------------------------修改完成---------------------------");
        else {
            System.out.println("------------------------------修改失败---------------------------");
        }
    }

    private void deleteCustomer(){
        System.out.println("------------------------------删除客户---------------------------");
        Customer customer;
        int index;
        for(;;){
            System.out.print("请选择待删除客户编号(-1)退出:");
            index = CMUtility.readInt();
            if(index==-1){
                return;
            }
            customer = customerList.getCustomer(index-1);
            if(customer==null){
                System.out.println("无法找到指定客户");
            }else{
                break;
            }
        }
        //找到要删除的对象之后
        System.out.println("确认是否删除(Y/N)：");
        char deleteOrNot = CMUtility.readConfirmSelection();
        boolean flag;
        if(deleteOrNot=='Y'){
            flag = customerList.deleteCustomer(index-1);
            if(flag){
                System.out.println("------------------------------删除完成---------------------------");
            }else {
                System.out.println("------------------------------删除失败--------------------------");
            }
        }else{
            return;
        }

    }

    private void listAllCustomers() {
        System.out.println("------------------------------客户列表--------------------------");
        Customer[] customers = customerList.getAllCustomers();
        if(customers.length==0) {
            System.out.println("没有客户记录！");
        }else {
            System.out.println("编号" + "\t" + "姓名" + "\t" + "性别" + "\t" + "年龄" + "\t" + "电话" + "\t" + "邮箱" + "\t");
            for (int i = 0; i < customers.length; i++) {
                System.out.println((i + 1) + "\t" + customers[i]);
            }
        }
        System.out.println("------------------------------客户列表完成------------------------");
    }

    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }
}
