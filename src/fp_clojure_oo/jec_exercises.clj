(ns fp-clojure-oo.jec-exercises)

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

(third [1 2 3 4 5 6])

(def third
  (fn [vec]
    (second (rest vec))))

(third [1 2 3 4 5 6])

;; #3
;; define add-squares
(def add-sqares
  (fn [& numbers]
    (apply + (map * numbers numbers))))

(add-sqares 1 2 3 4 5)

;; #4
;; implement factorial without loop or recursion
(def factorial
  (fn [end]
    (apply * (range 1 (inc end)))))

(factorial 5)

;; #5
;; TAKE : takes n first odd items
;; (take-n-odd 2 [1 2 3 4 5 6 7]) => (1 3)
(def takes
  (fn [nb vec]
    (take nb (filter odd? vec))))

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

;; Repeat
;; (repeat-third-and-fifth 3 '(W E A S B D)) => ((A B) (A B) (A B))
(def repeats
  (fn [seq]
    (repeat 3 (list (nth seq 2)
                    (nth seq 4)))))

(repeats '(W E A S B D))

;; INTERLEAVE
;; (separe-by-underscore [1 2 3 4]) => (1 _ 2 _ 3 _ 4)
(def interleaves
  (fn [seq]
    (interleave seq
                (repeat (inc (count seq)) '_))))

(interleaves [1 2 3 4])

;; DROP and DROP-LAST
;; Return the middlemost 2 elements of an even-element sequence.
;; (middlemost [1 2 3 4 5 6]) => (3 4)
(def trim
  (fn [seq]
    (- (/ (count seq) 2) 1)))

(def middlemost
  (fn [seq]
    (drop (trim seq)
               (drop-last (trim seq) seq))))

(middlemost [1 2 3 4 5 6])
(middlemost [1 2 3 4 5])
(middlemost [1 2 3 4 5])

;; FLATTEN
;; Add the elements of a sequence of elements without using `cons`
;; [+ [3 [5 6] 4]] => 18
(apply + (flatten [3 [5 6] 4]))

;; PARTITION
;; Convert (1 2 3 4) into (3 4 1 2)
(flatten (reverse (partition 2 '(1 2 3 4))))

;; EVERY?
;; Is ( () () () )  a list of empty lists?
(def all-are-empty?
  (fn [seq]
    (every? empty? seq)))

(all-are-empty? '(() () ()))

;; REMOVE
;; Remove all the nil values from a sequence
(def remove-nil
  (fn [seq]
    (remove nil? seq)))

(remove-nil [1 nil 2 nil 3])

;; #6
;; Returns true if the elements in the elements in the candidate are the first elements in the sequence
;; (prefix-of? [1 2] [1 2 3 4]) => true
;; (prefix-of? '(2 3) [1 2 3 4]) => false
;; (prefix-of? '(1 2) [1 2 3 4]) => true
(def prefix-of?
  (fn [cand seq]
    (= (take (count cand) seq)
       cand)))
(prefix-of? [1 2] [1 2 3 4])
(prefix-of? '(2 3) [1 2 3 4])
(prefix-of? '(1 2) '(1 2 3 4))

;; #7
;; Returns a sequence of successively smaller subsequences of the argument
;; (tails '(1 2 3 4)) => ((1 2 3 4) (2 3 4) (3 4) (4) ())
(def tails
  (fn [seq]
    (map drop
         (range (inc (count seq)))
         (repeat (inc (count seq)) seq))))

(tails '(1 2 3 4))
