public class Main {

    public static void main(String[] args) {
        try{
            new Main().exe();
         System.out.println("Main is ok");
        } catch (Exception e){
          System.out.println("Exception in Main");
        e.printStackTrace();
        }
    }

    private void exe() throws MyDomainException {
        try {
            deserialize("student");
        } catch (MyDomainException e) {
            System.out.println("Fail:" + e.getMessage());
            e.printStackTrace();
        }
        catch (Exception e){
            System.out.println("Epic fail:" + e.getMessage() );
            e.printStackTrace();
        }

        Student student = new Student();
        student.setName("Mark");
        student.setAge(25);

        //Переброс ошибки
        rethrowingExc(student);

        //Перехват ошибки и обращение ее в непроверяемое исключение
        uncheckedExc(student);

        //Демонстрация нескольких блоков Catch + блок Finally
        multiCatchAndFinally(student);
    }

    public Student deserialize(String n) throws MyDomainException{
        throw new MyDomainException();
    }

    public void rethrowingExc (Student student) throws MyDomainException{
        try {
            deserialize(student.getName());
            System.out.println("Ok");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Checked exception: " + e.getMessage());
            throw new MyDomainException();
        }
    }

    public void uncheckedExc (Student student) {
        try {
            deserialize(student.getName());
        } catch (MyDomainException e){
            System.out.println("Unchecked exception: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public int multiCatchAndFinally(Student student) {
        int n = student.getAge(); int k = 0; int l;
        try {  l = n/k;
            System.out.println("Look at the \"Finally\"");
        } catch (IllegalArgumentException e) {
            System.out.println("Exception in MultiCatch: " + e.getMessage());
            throw new IllegalArgumentException();
        } catch (SecurityException  e){
            System.out.println("Exception in MultiCatch: " + e.getMessage());
            throw new SecurityException ();
        } catch (IllegalCallerException   e){
            System.out.println("Exception in MultiCatch: " + e.getMessage());
            throw new IllegalCallerException();
        } catch (RuntimeException e) {
            System.out.println("Exception in MultiCatch: " + e.getMessage());
            throw new RuntimeException();
        }
            finally {
            System.out.println("Finally: You can't divide by zero!");
        }
        return l;
    }
}
