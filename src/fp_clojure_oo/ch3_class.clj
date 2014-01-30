(ns fp-clojure-oo.ch3-class)

(def Point
  (fn [x y]
    {:x x,
     :y y
     :__class_symbol__ 'Point}))

(def Triangle
  (fn [point1 point2 point3]
    {:p1 point1,
     :p2 point2,
     :p3 point3
     :__class_symbol__ 'Triangle}))

(def class-of
  (fn [this]
    (:__class_symbol__ this)))

(def x :x)
(def y :y)

(def shift
  (fn [this xinc yinc]
    (Point (+ (x this) xinc)
           (+ (y this) yinc))))

(def add-1
  (fn [this other]
    (Point (+ (x this) (x other))
           (+ (y this) (y other)))))

(def add
  (fn [this other]
    (shift this (x other) (y other))))

(def make
  (fn [this & args]
    (apply this args)))

(def equal-triangles? =)

(def valid-triangles?
  (fn [& points]
    (= (distinct points) points)))

(def right-triangle (Triangle (Point 0 0)
                              (Point 0 1)
                              (Point 1 0)))

(def equal-right-triangle (Triangle (Point 0 0)
                                    (Point 0 1)
                                    (Point 1 0)))

(def different-triangle (Triangle (Point 0 0)
                                  (Point 0 10)
                                  (Point 10 0)))
