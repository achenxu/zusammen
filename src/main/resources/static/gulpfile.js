'use strict'

var gulp = require('gulp');
var browserSync = require('browser-sync').create();
var sass = require('gulp-sass');
var del = require('del');
var runSequence = require('run-sequence');
var sourcemaps = require('gulp-sourcemaps');
var concat = require('gulp-concat');

gulp.paths = {
    dist: 'dist',
};

var paths = gulp.paths;

gulp.task('build', function() {
    runSequence(
        'clean:vendors',
        'copyRecursiveVendorFiles',
        'buildBaseVendorStyles',
        'buildBaseVendorScripts',
        'buildOptionalVendorScripts',
        'sass'
    );
});

gulp.task('clean:vendors', function () {
    return del([
      'vendors/**/*'
    ]);
});

gulp.task('copyRecursiveVendorFiles', function() {
    return gulp.src(['./node_modules/mdi/**/*'])
        .pipe(gulp.dest('./vendors/iconfonts/mdi'));
});

gulp.task('buildBaseVendorScripts', function() {
    return gulp.src([
        './node_modules/jquery/dist/jquery.min.js', 
        './node_modules/popper.js/dist/umd/popper.min.js', 
        './node_modules/bootstrap/dist/js/bootstrap.min.js', 
        './node_modules/perfect-scrollbar/dist/perfect-scrollbar.min.js'
    ])
      .pipe(concat('vendor.bundle.base.js'))
      .pipe(gulp.dest('./vendors/js'));
});

gulp.task('buildBaseVendorStyles', function() {
    return gulp.src(['./node_modules/perfect-scrollbar/css/perfect-scrollbar.css'])
      .pipe(concat('vendor.bundle.base.css'))
      .pipe(gulp.dest('./vendors/css'));
});

gulp.task('buildOptionalVendorScripts', function() {
    return gulp.src([
        'node_modules/chart.js/dist/Chart.min.js', 
    ])
    .pipe(concat('vendor.bundle.addons.js'))
    .pipe(gulp.dest('./vendors/js'));
});

gulp.task('sass', function () {
    return gulp.src('./scss/style.scss')
        .pipe(sourcemaps.init())
        .pipe(sass({outputStyle: 'expanded'}).on('error', sass.logError))
        .pipe(sourcemaps.write('./maps'))
        .pipe(gulp.dest('./css'))
        .pipe(browserSync.stream());
});

gulp.task('default', ['build']);
