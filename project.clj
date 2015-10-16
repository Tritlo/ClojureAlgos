(defproject binaryclj "0.0.1-SNAPSHOT"
  :description "Binary trees in Clojure, as an excercise"
  :url "http://github.com/Tritlo/binaryclj"
  :license {:name "MIT"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [
                 [org.clojure/clojure "1.7.0"]
                 ]
  :main ^:skip-aot binaryclj.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
