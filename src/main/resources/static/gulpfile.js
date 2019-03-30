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
        'copyRecursiveLeafletFiles',
        'copyRecursiveFontAwesomeFiles',
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

gulp.task('copyRecursiveLeafletFiles', function() {
    return gulp.src(['./node_modules/leaflet/dist/images/*'])
        .pipe(gulp.dest('./vendors/css/images'));
});

gulp.task('copyRecursiveFontAwesomeFiles', function() {
    return gulp.src(['./node_modules/font-awesome/fonts/*'])
        .pipe(gulp.dest('./vendors/fonts'));
});

gulp.task('buildBaseVendorScripts', function() {
    return gulp.src([
        './node_modules/jquery/dist/jquery.min.js', 
        './node_modules/popper.js/dist/umd/popper.min.js', 
        './node_modules/bootstrap/dist/js/bootstrap.min.js', 
        './node_modules/perfect-scrollbar/dist/perfect-scrollbar.min.js',
        './node_modules/leaflet/dist/leaflet.js',
        './node_modules/moment/min/moment.min.js',
        './node_modules/tempusdominus-bootstrap-4/build/js/tempusdominus-bootstrap-4.js'
    ])
      .pipe(concat('vendor.bundle.base.js'))
      .pipe(gulp.dest('./vendors/js'));
});

gulp.task('buildBaseVendorStyles', function() {
    return gulp.src([
        './node_modules/perfect-scrollbar/css/perfect-scrollbar.css',
        './node_modules/leaflet/dist/leaflet.css',
        './node_modules/font-awesome/css/font-awesome.css',
        './node_modules/tempusdominus-bootstrap-4/build/css/tempusdominus-bootstrap-4.css'
    ])
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
