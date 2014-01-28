(ns fp-clojure-oo.map)

;; Init map
{:a 1, "b" 2} ;; it's very common to use colon-prfixed keywords, so :b is better than "b"
(hash-map :a 1 :b 2)
(apply hash-map [:a 1 :b 2]) ;; it's not unusual to apply hash-map to a sequence

(def do-something-with-a-colored-point
  (fn [& args]
    (apply hash-map args)))
(do-something-with-a-colored-point :a "foo", :b 2, :y 3)

;; get a value (Rare)
(get {:a 2, :b 6} :a)
;; if map does not contain a key
(get {} :a) ;; nil

;; get the swag way !
(:a {:a 1, :b 2})
;; Example:
(def do-something-to-map
  (fn [function]
    (function {:a "I'm A", :b "I'm B"})))
(do-something-to-map :a)
(do-something-to-map count)

(assoc {:a 1, :b 2} :c 3) ;; {:c 3, :a 1, :b 2}
(assoc {:a 1, :b 2} :c 3 :d 4 :e 5) ;; {:e 5, :d 4, :c 3, :a 1, :b 2}
(assoc {:a 1, :b 2} :b 333333 :d 4 :e 5) ;; {:e 5, :d 4, :a 1, :b 333333}

(merge {:a 1, :b 2} {:c 3, :d 4} {:e 5}) ;; {:e 5, :d 4, :c 3, :a 1, :b 2}
(merge {:a 1, :b 2} {:b 333333, :d 4} {:e 5}) ;; {:e 5, :d 4, :a 1, :b 333333}

(dissoc {:a 1, :b 2, :c 3} :b :c) ;; {:a 1}

(def Point
  (fn [x y]
    {:x x
     :y y
     :__class_symbol__ 'Point}))

;; GETTERS
;; (def x
;;  (fn [this] (get this :x)))
;; OR
;;(def x
;; (fn [this] (:x this)))

;; But better
(def x :x)
