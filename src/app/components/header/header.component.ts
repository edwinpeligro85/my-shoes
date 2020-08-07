import { Component, OnInit, AfterViewInit, ViewChild, ElementRef, Renderer2, HostListener, Inject, PLATFORM_ID } from '@angular/core';
import { isPlatformBrowser } from '@angular/common';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit, AfterViewInit {

  @ViewChild('header') private headerRef: ElementRef;
  @ViewChild('menu') private menuRef: ElementRef;
  @ViewChild('fsOverlay') private fsOverlayRef: ElementRef;

  private menuActive = false;
  private header: any;
  private menu: any;
  private fsOverlay: any;
  private width: number;
  private scroll: number;
  public toggleMenuItem = false;
  public rutas = [
    { name: 'Inicio',   path: '/home' },
    { name: 'Tienda',   path: '/shop' },
    { name: 'Contacto', path: '/contact' }
  ];

  // tslint:disable-next-line:ban-types
  constructor(private renderer: Renderer2, @Inject(PLATFORM_ID) private platformId: Object) { }

  ngOnInit(): void {
    // Código exclusivo del cliente.
    if (isPlatformBrowser(this.platformId)) {
      this.width = screen.width;
      this.scroll = window.scrollY;
    }
  }

  ngAfterViewInit(): void {
    this.header = this.headerRef.nativeElement;
    this.menu = this.menuRef.nativeElement;
    this.fsOverlay = this.fsOverlayRef.nativeElement;
    this.setHeader();

    // this.initMenu();
  }

  @HostListener('window:resize', ['$event']) onResize(event: any) {
    this.width = event.target.innerWidth;
    this.setHeader();
  }

  @HostListener('window:scroll', ['$event']) onScroll(event: any) {
    this.scroll = event.path[1].scrollY;
    this.setHeader();
  }

  setHeader() {
    if (this.width < 992 && this.scroll > 100) {
      this.renderer.setStyle(this.header, 'top', '0');
    }
    else {
      if (this.scroll > 100) {
        this.renderer.setStyle(this.header, 'top', '-50px');
      } else {
        this.renderer.setStyle(this.header, 'top', '0');
      }
    }
    if (this.width > 991 && this.menuActive) {
      this.closeMenu();
    }
  }

  toggleDropDown() {
    this.toggleMenuItem = !this.toggleMenuItem;
  }

  openMenu() {
    this.renderer.addClass(this.menu, 'active');
    this.renderer.setStyle(this.fsOverlay, 'pointer-events', 'auto');
    this.menuActive = true;
  }

  closeMenu() {
    this.renderer.removeClass(this.menu, 'active');
    this.renderer.setStyle(this.fsOverlay, 'pointer-events', 'none');
    this.menuActive = false;
  }

}
