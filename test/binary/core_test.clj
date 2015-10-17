(ns binary.core-test
  (:require [clojure.test :refer :all]
            [binary.core :refer :all]))
(def test-tree  (insert (insert (insert ( insert (insert (leaf 100) 12) 120 ) 57) 130) 110))

(deftest creation-test
  (testing "Creation."
    (do
      (def a (leaf 100))
      (is (and (= 100 (:key a )) (nil? (:left a)) (nil? (:right a)))))))

(deftest insert-test
  (testing "Insertion"
    (do
      (def a (leaf 100))
      (def b (insert a 20))
      (is (= 20 (:key (:left b)))))))

(deftest inorder-test
  (testing "In order"
      (is (= (traverse test-tree) (sort (traverse test-tree))))))

(deftest search-test
  (testing "Insertion"
      (is (= [12 57]  (traverse (search test-tree 12)) ))))

(deftest traverse-test
  (testing "Traversion"
      (is (= (traverse test-tree) [12 57 100 110 120 130]))))

(deftest delete-test
  (testing "Deletion"
      (is (= (traverse (delete test-tree 100)) [12 57 110 120 130]))))
