(ns fp-clojure-oo.just_enough_clojure_exercises)

;; EXERCISES :

;; #1
;; Given what you know now, can you define a function second that
;; returns the second element of a list ? That is, fill in the blank
;; in this:
;; (def second (fn [vec] ____))
(def second
  (fn [vec]
    (first (rest vec))))
(second [1 2 3 4])

;; #2
;; Same with third (2 implementations)
(def third
  (fn [vec]
    (first (rest (rest vec)))))
(third [1 2 3 4])

(def third-2
  (fn [vec]
    (second (rest vec))))
(third-2 [1 2 3 4])

;; #3
;; define add-squares
(def add-squares
  (fn [& numbers]
    (apply + (map * numbers numbers))))
(add-squares 1 2)

;; #4
;; implement factorial without loop or recursion
(def factorial
  (fn [x]
    (apply * (range 1 (inc x)))))
(factorial 5)

;; #5
;; TAKE : takes n first odd items
;; (take-n-odd 2 [1 2 3 4 5 6 7]) => (1 3)
(def takes
  (fn [n seq]
    (take n (filter odd? seq))))
(takes 2 [1 2 3 4 5 6 7])

;; DISTINCT : Count how many elements are duplicated in two seq
;; (count-redundancies [1 2 3 3 4 5 6 6 7]) => 2
(def count-redundancies
  (fn [seq]
    (- (count seq)
       (count (distinct seq)))))
(count-redundancies [1 2 3 3 4 5 6 6 7])

;; CONCAT : concats first, two and three elements of lists '(A _ _ _) '(B C _ _) '(D E F _) => (A B C D E F)
(concat (take 1 '(A _ _ _))
        (take 2 '(B C _ _))
        (take 3 '(D E F _)))

;; REPEAT
;; (repeat-third-and-fifth 3 '(W E A S B D)) => ((A B) (A B) (A B))
(def repeats
  (fn [n seq]
    (repeat n (list (nth seq 2) (nth seq 4)))))
(repeats 3 '(W E A S B D))

;; INTERLEAVE
;; (separe-by-underscore [1 2 3 4]) => (1 _ 2 _ 3 _ 4)
(def interleaves
  (fn [seq]
    (interleave seq
                (repeat (count seq) '_))))
(interleaves [1 2 3 4])

;; DROP and DROP-LAST
;; Return the middlemost 2 elements of an even-element sequence.
;; (middlemost [1 2 3 4 5 6]) => (3 4)

;; FLATTEN
;; Add the elements of a sequence of elements without using `cons`
;; [+ [3 [5 6] 4]] => 18

;; PARTITION
;; Convert (1 2 3 4) into (3 4 1 2)

;; EVERY?
;; Is ( () () () )  a list of empty lists?

;; REMOVE
;; Remove all the nil values from a sequence

;; #6
;; Returns true if the elements in the elements in the candidate are the first elements in the sequence
;; (prefix-of? [1 2] [1 2 3 4]) => true
;; (prefix-of? '(2 3) [1 2 3 4]) => false
;; (prefix-of? '(1 2) [1 2 3 4]) => true

;; #7
;; Returns a sequence of successively smaller subsequences of the argument
;; (tails '(1 2 3 4)) => ((1 2 3 4) (2 3 4) (3 4) (4) ())

;; #8
;; In the first exercise in the chapter, I asked you to complete this function
;; (def second (fn [list] ____))
;; (puzzle '(1 2 3)) => list is a core function substitution => fn [(1 2 3)] ((1 2 3) (1 2 3)) where is a function ?





