(ns fp-clojure-oo.class-in-constructor)

(def make
  (fn [type & args]
    (apply type args)))

(def Point
  (fn [x y]
    { ;; initializing instance variables
     :x x,
     :y y
     ;; Metadata
     :__class_symbol__ 'Point
     :__methods__ {
                   :class :__class_symbol__
                   :x :x
                   :y :y
                   :shift
                   (fn [this xinc yinc]
                     (make Point
                           (+ (send-to this :x) xinc)
                           (+ (send-to this :y) yinc)))
                   :add
                   (fn [this other]
                     (send-to this :shift
                              (send-to other :x)
                              (send-to other :y)))}}))

;; Retrieve a method is a bit complicated
(:shift (:__methods__ (make Point 1 2)))

;; Applying one is not exactly graceful
(def point (make Point 1 2))
((:shift (:__methods__ point)) point -2 -3)

;; send-to function that looks more like a message send
(def send-to
  (fn [object message & args]
    (apply (message (:__methods__ object)) object args)))

(send-to point :shift -2 -3)
(send-to point :add (make Point -2 -3))
