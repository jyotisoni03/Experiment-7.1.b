import jakarta.persistence.*;

public class StudentDao {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentPU");

    public Student create(Student student) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(student);
        tx.commit();
        em.close();
        return student;
    }

    public Student find(Long id) {
        EntityManager em = emf.createEntityManager();
        Student s = em.find(Student.class, id);
        em.close();
        return s;
    }

    public Student update(Long id, String newDept) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Student s = em.find(Student.class, id);
        if (s != null) {
            s.setDepartment(newDept);
        }
        tx.commit();
        em.close();
        return s;
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Student s = em.find(Student.class, id);
        if (s != null) {
            em.remove(s);
        }
        tx.commit();
        em.close();
    }
}
