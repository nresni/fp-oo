(ns fp-clojure-oo.embedding-oo)

(def Point
  (fn [x y]
    {:x x, :y y
     :__class_symbol__ 'Point}))

(def x :x)
(def y :y)
(def class-of :__class_symbol__)

(def shift
  (fn [this xinc yinc]
    (Point (+ (x this) xinc)
           (+ (y this) yinc))))
(def add
  (fn [p1 p2]
    (Point (+ (x p1) (x p2))
           (+ (y p1) (y p2)))))
(def add-2
  (fn [p1 p2]
    (shift p1 (x p2) (y p2))))

(def make
  (fn [type & args]
    (apply type args)))

(make Point 1 2)

(def Triangle
  (fn [point1 point2 point3]
    {:point1 point1, :point2 point2, :point3 point3
     :__class_symbol__ 'Triangle}))

;;(def equal-triangles?
;;(fn [t1 t2]
;;  (= t1 t2)
;;))

;; More elegant
(def equal-triangles? =)
(equal-triangles? (Point 1 2) (Point 3 4))
(equal-triangles? (Point 1 2) (Point 1 2))

(make Triangle
      (make Point 1 2)
      (make Point 1 3)
      (make Point 3 1))

(def right-triangle (Triangle (Point 0 0)
                              (Point 0 1)
                              (Point 1 0)))

(def equal-right-triangle (Triangle (Point 0 0)
                                    (Point 0 1)
                                    (Point 1 0)))

(def different-triangle (Triangle (Point 0 0)
                                  (Point 0 10)
                                  (Point 10 0)))

(equal-triangles? right-triangle right-triangle)
(equal-triangles? right-triangle equal-right-triangle)
(equal-triangles? right-triangle different-triangle)

(def valid-triangle?
  (fn [& args]
    (= (distinct args) args)))

(valid-triangle? (Point 1 2) (Point 3 4) (Point 5 6))
(valid-triangle? (Point 1 2) (Point 3 4) (Point 3 4))
(valid-triangle? (Point 1 2) (Point 3 4))

;; If we want to check that we have thre right number of points
(def valid-triangle?
  (fn [& args]
    (and (= 3 (count args))
         (= (distinct args) args))))
(valid-triangle? (make Point 0 0) (make Point 0 1))
(valid-triangle? (make Point 0 0) (make Point 0 0) (make Point 3 4))
(valid-triangle? (make Point 0 0) (make Point 0 3) (make Point 3 0))
