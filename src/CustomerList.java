public class CustomerList {
    int total;
    Customer[] customers;
    public CustomerList(){
        this.total = 0;
    }
    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }
    // 将参数customer添加到数组中最后一个客户对象记录之后
    public boolean addCustomer(Customer customer){
        if(customer!=null&&total<customers.length){
            customers[total++] = customer;
            return true;
        }
        return false;
    }

    // 用参数customer替换数组中由index指定的对象
    public boolean replaceCustomer(int index,Customer cust){
        if(index>=0&&index<total){
            customers[index] = cust;
            return true;
        }
        return false;
    }
    //删除参数index指定索引位置的客户对象记录
    public boolean deleteCustomer(int index){
        if(index<0||index>=total) return false;
        for(int i = index;i<total-1;i++){
            customers[i] = customers[i+1];
        }
        customers[--total] = null;
        return true;
    }

    // 返回数组中记录的所有客户对象
    public Customer[] getAllCustomers(){
        Customer[] custs = new Customer[total];
        for(int i = 0;i<custs.length;i++){
            custs[i] = customers[i];
        }
        return custs;
    }
    // 返回指定index位置的客户对象记录
    public Customer getCustomer(int index){
        if(index>=0&&index<total)
            return customers[index];
        return null;
    }
    public int getTotal(){
        return total;
    }

}
