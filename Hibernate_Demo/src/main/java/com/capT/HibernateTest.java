package com.capT;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateTest {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        
        try {
            System.out.println("========================================");
            System.out.println("Starting Hibernate Configuration Test");
            System.out.println("========================================\n");
            
            System.out.println("Step 1: Creating EntityManagerFactory...");
            emf = Persistence.createEntityManagerFactory("hibernateDemo");
            System.out.println("✓ EntityManagerFactory created!\n");
            
            System.out.println("Step 2: Creating EntityManager...");
            em = emf.createEntityManager();
            System.out.println("✓ EntityManager created!\n");
            
            System.out.println("Step 3: Testing transaction...");
            em.getTransaction().begin();
            System.out.println("✓ Transaction started!");
            em.getTransaction().commit();
            System.out.println("✓ Transaction committed!\n");
            
            System.out.println("========================================");
            System.out.println("✓✓✓ SUCCESS! Hibernate is working! ✓✓✓");
            System.out.println("========================================");
            
        } catch (Exception e) {
            System.err.println("\n❌ ERROR: " + e.getMessage());
            System.err.println("\nCheck: PostgreSQL running? Database 'EMP' exists? Credentials correct?");
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
            if (emf != null && emf.isOpen()) emf.close();
        }
    }
}
