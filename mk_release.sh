#!/bin/sh -e

build() {
ant clean && ant default
}

VERSION=13
PRETTYVERSION=$(grep VERSION src/lsystem/Grammar.java | awk -F" " '{print $6}' | sed -e 's/"//g;s/;//g')

base_rel_dir=lsystem # FIXME: use project name
up_host=people.piment-noir.org
up_user=fraggle
up_path=~/public_html/lsystem

sed -e "s/@VERSION@/${VERSION}/;s/@PRETTYVERSION@/${PRETTYVERSION}/" < src/lsystem/library.properties.in > src/lsystem/library.properties 
[ -d release ] && rm -fr release
mkdir -p release/${base_rel_dir}/library release/${base_rel_dir}/reference
build
[ $? -ne 0 ] && exit 1
cp dist/lsystem.jar release/${base_rel_dir}/library/
cp -a dist/javadoc/* release/${base_rel_dir}/reference/ 
cp -a examples release/${base_rel_dir}/
cp -a src release/${base_rel_dir}/
cp lgpl-2.1.txt release/${base_rel_dir}/
mv src/lsystem/library.properties release/${base_rel_dir}/
cd release
zip -r ${base_rel_dir}-${PRETTYVERSION}.zip ${base_rel_dir}
scp ${base_rel_dir}-${PRETTYVERSION}.zip ${up_user}@${up_host}:$up_path/ 

