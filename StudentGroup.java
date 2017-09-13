import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.Period;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 *
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;

	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		if(students==null)
           throw new IllegalArgumentException();
            else
            this.students=students;
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if(index>students.length || index<0)
            throw new IllegalArgumentException();
        else
		return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		if(student==null || (index>students.length || index<0) )
            throw new IllegalArgumentException();

    else
            students[index]=student;

	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		int i;
		if(student==null)
            throw new IllegalArgumentException();
        else
        {
            Student[] stu=new Student[students.length+1];
        stu[0]=student;
        for(i=1;i<stu.length;i++)
            stu[i]=students[i-1];
        students=stu;
        }

	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		int i;
		if(student==null)
           throw new IllegalArgumentException();
        else
        {
            Student[] stu=new Student[students.length+1];
        for(i=0;i<stu.length-1;i++)
            stu[i]=students[i];
        stu[i]=student;
        students=stu;
        }

	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		int i;
		if(student==null || (index>students.length || index<0) )
            throw new IllegalArgumentException();
        else
        {
            Student[] stu=new Student[students.length+1];
        for(i=0;i<index;i++)
            stu[i]=students[i];
        stu[i]=students[i];
        for(i=index+1;i<students.length;i++)
            stu[i+1]=students[i];
        students=stu;
        }


	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		int i;
		if(index>students.length || index<0)
            throw new IllegalArgumentException();
        else
        {
            Student[] stu=new Student[students.length-1];
        for(i=0;i<index;i++)
            stu[i]=students[i];
        for(i=index+1;i<students.length;i++)
            stu[i-1]=students[i];
        students=stu;
        }
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		int f=0,i;
		if(students==null)
            throw new IllegalArgumentException();
        else
        {
            for(i=0;i<students.length;i++)
            {
                if(student.compareTo(students[i])==0)
                {
                    f=1;
                    break;
                }
            }
            if(f==0)
                throw new IllegalArgumentException();
            else
                remove(i);
        }
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		if(index>students.length || index<0)
            throw new IllegalArgumentException();
        else
        {
            Student[] stu=new Student[index];
            for(int i=0;i<=index;i++)
                stu[i]=students[i];
            students=stu;
        }
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		int f=0,i;
		if(students==null)
            throw new IllegalArgumentException();
        else
        {
            for(i=0;i<students.length;i++)
            {
                if(student.compareTo(students[i])==0)
                {
                    f=1;
                    break;
                }
            }
            if(f==0)
                throw new IllegalArgumentException();
            else
                removeFromIndex(i);
        }

	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		if(index>students.length || index<0)
           throw new IllegalArgumentException();
        else
        {
            int k=0;
            Student[] stu=new Student[students.length-index];
            for(int i=index;i<students.length;i++)
                stu[k++]=students[i];
            students=stu;
        }
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		int f=0,i;
		if(students==null)
            throw new IllegalArgumentException();
        else
        {
            for(i=0;i<students.length;i++)
            {
                if(student.compareTo(students[i])==0)
                {
                    f=1;
                    break;
                }
            }
            if(f==0)
                throw new IllegalArgumentException();
            else
                removeToIndex(i);
        }

	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		Student temp;
		for(int i=0;i<students.length-1;i++)
        {
            for(int j=i+1;j<students.length;j++)
            {
                if(students[i].compareTo(students[j])>0)
                {
                    temp=students[i];
                    students[i]=students[j];
                    students[j]=temp;
                }
            }
        }
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		//List<Student> ha=new ArrayList<Student>();
		int count=0;
		if(date==null)
           throw new IllegalArgumentException();
        else
        {
            for(int i=0;i<students.length;i++)
                if(students[i].getBirthDate().compareTo(date)==0)
                count++;
            Student[] stu=new Student[count];
            int j=0;
            for(int i=0;i<students.length;i++)
                if(students[i].getBirthDate().compareTo(date)==0)
                    stu[j++]=students[i];
            return stu;
        }
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		int count=0;
		if(firstDate==null || lastDate==null)
           throw new IllegalArgumentException();
        else
        {

         for(int i=0;i<students.length;i++)
                if(students[i].getBirthDate().compareTo(lastDate)<=0&&students[i].getBirthDate().compareTo(firstDate)>=0)
                count++;
         Student[] stu=new Student[count];
         int j=0;
         for(int i=0;i<students.length;i++)
                if(students[i].getBirthDate().compareTo(lastDate)<=0&&students[i].getBirthDate().compareTo(firstDate)>=0)
                    stu[j++]=students[i];
         return stu;
        }
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here

		String d=date.toString();
		if(date==null)
        throw new IllegalArgumentException();
        else
        {
            int count=0;
            for(int i=0;i<students.length;i++)
                if(students[i].getBirthDate().toString().compareTo(d)<=days&&students[i].getBirthDate().toString().compareTo(d)>=0)
                    count++;
            Student[] stu=new Student[count];
            int j=0;
             for(int i=0;i<students.length;i++)
                if(students[i].getBirthDate().toString().compareTo(d)<=days&&students[i].getBirthDate().toString().compareTo(d)>=0)
                    stu[j++]=students[i];
                return stu;

        }
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		if(indexOfStudent<0 || indexOfStudent>=students.length)
        throw new IllegalArgumentException();
        else
        {
            String ddd=students[indexOfStudent].getBirthDate().toString();
            LocalDate ld=LocalDate.parse(ddd);
            LocalDate presentDate=LocalDate.now();
            return Period.between(ld,presentDate).getYears();
        }
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		int count=0;
		for(int i=0;i<students.length;i++)
        {
            if(getCurrentAgeByDate(i)==age)
                count++;
        }
        Student[] stu =new Student[count];
        int j=0;
        for(int i=0;i<students.length;i++)
        {
            if(getCurrentAgeByDate(i)==age)
                stu[j++]=students[i];
        }
		return stu;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		//List<Student> ha=new ArrayList<Student>();
		double max=-99999;int count=0;
		for(int i=0;i<students.length;i++)
            if(max<students[i].getAvgMark())
            max=students[i].getAvgMark();
        for(int i=0;i<students.length;i++)
            if(students[i].getAvgMark()==max)
          count++;
        Student[] stu=new Student[count];
        int j=0;
        for(int i=0;i<students.length;i++)
             if(students[i].getAvgMark()==max)
        stu[j++]=students[i];
        return stu;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		if(student==null)
            throw new IllegalArgumentException();
        else
        {
            for(int i=0;i<students.length;i++)
            {
                if(student.compareTo(students[i])==0)
                    return students[i+1];
            }
        }
		return null;
	}
}
