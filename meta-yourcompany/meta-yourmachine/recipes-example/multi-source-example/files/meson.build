project('multi-source-example', 'c')

src_dir = 'src'
inc_dir = 'include'

executable('my_app',
  files(
    src_dir + '/main.c',
    src_dir + '/foo.c',
    src_dir + '/bar.c'
  ),
  include_directories: include_directories(inc_dir)
)
