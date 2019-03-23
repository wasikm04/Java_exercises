package blackredtree;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

public class RedBlackTreeTest {

    public RedBlackTreeTest() {
    }

    @Test
    public void set_different_values_in_same_node() {
        RedBlackTree<Integer, Double> tree = new RedBlackTree<Integer, Double>();

        tree.setValue(3, 8.0);
        tree.setValue(3, 1.0);
        tree.setValue(4, 4.0);
        tree.setValue(2, 2.0);

        tree.setValue(3, 9.0);
        assertNotNull(tree.getValue(3));
        assertEquals(tree.getValue(3), 9.0, 0);

    }

    @Test
    public void get_value_should_return_10() {
        RedBlackTree<Integer, Double> tree = new RedBlackTree<Integer, Double>();

        tree.setValue(1, 10.0);

        Double value = tree.getValue(1);

        assertEquals(value, 10.0, 0);
    }

    @Test
    public void check_if_root_is_black_after_addition_few_nodes() {
        RedBlackTree<Integer, Double> tree = new RedBlackTree<Integer, Double>();
        tree.setValue(8, 1.0);
        tree.setValue(18, 2.0);
        tree.setValue(5, 3.0);
        tree.setValue(15, 4.0);
        assertFalse(tree.getRoot().isRed());

    }

    @Test
    public void check_if_colors_changed_when_there_are_2_red_nodes_in_sequence() {
        RedBlackTree<Integer, Double> tree = new RedBlackTree<Integer, Double>();
        //Kolor czerwony jest gdy isRed() zwraca true a czarny gdy ta funkcja zwraca false
        tree.setValue(2, 1.0);
        tree.setValue(3, 2.0);

        //kolor 3 przed rotacja czerwony
        assertTrue(tree.getRoot().getRight().isRed());

        //kolor 2 przed rotacją false - czarny ponieważ jest korzeniem
        assertFalse(tree.getRoot().isRed());

        tree.setValue(4, 3.0);
        tree.setValue(5, 4.0);

        //Po rotacji i dodaniu nowego węzła korzeń i jego dzieci są czarne a nowo dodany prawy skrajny węzeł czerwony      
        assertFalse(tree.getRoot().getLeft().isRed());
        assertFalse(tree.getRoot().getRight().isRed());
        assertTrue(tree.getRoot().getRight().getRight().isRed());

    }

    @Test
    public void check_if_nodes_are_on_the_right_places() {
        RedBlackTree<Integer, Double> tree = new RedBlackTree<Integer, Double>();
        // Węzły dodawane są w kolejności 10 > 16 > 23 > 56 > 4 > 18 > 40 > 2
        // Wybrane 2 węzły przykładowe, 10 po rotacji
        tree.setValue(10, 1.0);
        tree.setValue(16, 2.0);
        tree.setValue(23, 3.0);
        tree.setValue(56, 4.0);
        tree.setValue(4, 5.0);
        tree.setValue(18, 6.0);
        tree.setValue(40, 7.0);
        tree.setValue(2, 8.0);

        assertEquals(tree.getValue(10), tree.getRoot().getLeft().getRight().getValue());
        assertEquals(tree.getValue(18), tree.getRoot().getRight().getLeft().getValue());
    }

    @Test
    public void Average_time_of_setting_and_getting_with_different_amount_of_nodes() {
        RedBlackTree<Integer, Double> tree = new RedBlackTree<Integer, Double>();
        Random rand = new Random();
        double avgset =0;
        double avgget =0;
        
        //Średnia będzie wyliczana z 1000 prób po 1000, 2000, 3000, 5000, 10000  węzłów każda
        
        //1000 prób
        
        for (int j = 0; j < 1000; j++) {
            for (int i = 0; i < 1000; i++) {
                tree.setValue(i, rand.nextDouble() * 10);
            }
            long start = System.nanoTime();
            tree.setValue(1000, 10.0);
            long time = System.nanoTime() - start;
            avgset = (avgset + time);
            
            start = System.nanoTime();
            tree.getValue(1000);
            time = System.nanoTime() - start; 
            avgget = (avgget + time);
            
        }
        System.out.println("Średni czas szukania z 1000 węzłów: " + avgset/1000);
        System.out.println("Średni czas dodawania z 1000 węzłów: " + avgget/1000);
        
      
        //2000 węzłów
        
       
        for (int j = 0; j < 1000; j++) {
            for (int i = 0; i < 2000; i++) {
                tree.setValue(i, rand.nextDouble() * 10);
            }
            long start = System.nanoTime();
            tree.setValue(1000, 10.0);
            long time = System.nanoTime() - start;
            avgset = (avgset + time);
            
            start = System.nanoTime();
            tree.getValue(1000);
            time = System.nanoTime() - start; 
            avgget = (avgget + time);
            
        }
        System.out.println("Średni czas szukania z 2000 węzłów: " + avgset/1000);
        System.out.println("Średni czas dodawania z 2000 węzłów: " + avgget/1000);
        
        //3000 węzłów
         
        for (int j = 0; j < 1000; j++) {
            for (int i = 0; i < 3000; i++) {
                tree.setValue(i, rand.nextDouble() * 10);
            }
            long start = System.nanoTime();
            tree.setValue(1000, 10.0);
            long time = System.nanoTime() - start;
            avgset = (avgset + time);
            
            start = System.nanoTime();
            tree.getValue(1000);
            time = System.nanoTime() - start; 
            avgget = (avgget + time);
            
        }
        System.out.println("Średni czas szukania z 3000 węzłów: " + avgset/1000);
        System.out.println("Średni czas dodawania z 3000 węzłów: " + avgget/1000);
        
        //5000 węzłów
        
         
        for (int j = 0; j < 1000; j++) {
            for (int i = 0; i < 5000; i++) {
                tree.setValue(i, rand.nextDouble() * 10);
            }
            long start = System.nanoTime();
            tree.setValue(1000, 10.0);
            long time = System.nanoTime() - start;
            avgset = (avgset + time);
            
            start = System.nanoTime();
            tree.getValue(1000);
            time = System.nanoTime() - start; 
            avgget = (avgget + time);
            
        }
        System.out.println("Średni czas szukania z 5000 węzłów: " + avgset/1000);
        System.out.println("Średni czas dodawania z 5000 węzłów: " + avgget/1000);
        
        
        
        
        //10000 węzłów
        
        for (int j = 0; j < 1000; j++) {
            for (int i = 0; i < 10000; i++) {
                tree.setValue(i, rand.nextDouble() * 10);
            }
            long start = System.nanoTime();
            tree.setValue(1000, 10.0);
            long time = System.nanoTime() - start;
            avgset = (avgset + time);
            
            start = System.nanoTime();
            tree.getValue(1000);
            time = System.nanoTime() - start; 
            avgget = (avgget + time); //ms
            
        }
        System.out.println("Średni czas szukania z 10000 węzłów: " + avgset/1000);
        System.out.println("Średni czas dodawania z 10000 węzłów: " + avgget/1000);
        
      
    }

}
