package com.notepubs.web.config;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.notepubs.web.entity.*;


public class Ex3_OneToManyProgram {

   public static void main(String[] args) {
      
      SessionFactory factory = new Configuration()
                           .configure("com/notepubs/web/config/hibernate.cfg.xml")
                           .addAnnotatedClass(Book.class)
                           .addAnnotatedClass(BookDetail.class)
                           .addAnnotatedClass(Note.class) //이걸로 엔티티 추가할 수 있음(hibernate.cfg.xml에서 해도되고)
                           .addAnnotatedClass(NoteView.class)
                           .addAnnotatedClass(Comment.class)
                           .buildSessionFactory();
      
      Session session = factory.getCurrentSession();
      session.beginTransaction();
      
      /*-------1. Note 목록 가져오기--------*/
      //List<Note> notes = session.createQuery("from Note").getResultList();
      
      Query query = session.createQuery("from Note", Note.class);
      List<Note> notes = query.getResultList();
      
      for(Note n: notes)
         System.out.println(n.getTitle());
         
      

      
      /*-------2. 각 Note에 Comment 목록을 채우기--------*/
      /*for(Note n : notes) {
    	  Query query1 = session.createQuery("from Comment where noteId=:noteId", Comment.class);
    	  query1.setParameter("noteId", n.getId());
    	  List<Comment> comments= query1.getResultList();
    	  n.setComments(comments);
      }*/
      
      /*-------3. NoteView 목록 가져오기--------*/
      /*Query query = session.createQuery("from NoteView", NoteView.class);
      List<Note> notes = query.getResultList();
      
      for(Note n : notes)
    	  System.out.println(n.getTitle());*/
      
      /*Note note = session.get(Note.class, 76);
      System.out.println(note.getTitle());
      List<Book> books = note.getBooks();
      
      for(Book b : books)
    	  System.out.println("booktitle:" + b.getTitle());*/
      
      session.getTransaction().commit();
      session.close();
      factory.close();
   }

}