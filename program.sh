#!/bin/bash

repl(){
  clj \
    -J-Dclojure.core.async.pool-size=8 \
    -X:Ripley Ripley.core/process \
    :main-ns Solo.main
}


main(){
  clojure \
    -J-Dclojure.core.async.pool-size=8 \
    -M -m Solo.main
}

jar(){

  rm -rf out/*.jar out/classes
  clojure \
    -X:Genie Genie.core/process \
    :main-ns Solo.main \
    :filename "\"out/Solo-$(git rev-parse --short HEAD).jar\"" \
    :paths '["src"]'
}

release(){
  jar
}

"$@"