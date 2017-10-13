package projectfinal;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

import com.jogamp.opengl.util.Animator;
import static java.lang.Math.round;

public class ProjectFinal implements GLEventListener {

    static private double theta = 0;
    static private double beta = 0;
    int flag = 0;
    int flag2 = 0;
    double x0 = 0.3;
    double y0 = 0.2;
    double x1 = 0.7;
    double y1 = 0.4;
    double x2 = 0.5;
    double y2 = 0.3;
    double x3 = 0.9;
    double y3 = 0.5;
    double z = 0;
    double a0 = 0.3;
    double b0 = -0.1;
    double a1 = 0.7;
    double b1 = 0.1;
    double a2 = 0.5;
    double b2 = 0.2;
    double a3 = 0.9;
    double b3 = 0.4;
    double c0 = 0.3;
    double d0 = 0.3;
    double c1 = 0.7;
    double d1 = 0.5;
    double c2 = 0.5;
    double d2 = 0.6;
    double c3 = 0.9;
    double d3 = 0.8;
    double c4 = 0.5;
    double c5 = 0.7;
    double c6 = 0.47;
    double c7 = 0.52;
    double d4 = 0.36;
    double d5 = 0.42;
    double f0 = 0;
    double f1 = 0;
    double g0 = 0;
    double g1 = 0;
    double angle = 0;
    double radius = 0;
    public static Animator animator;

    public static void main(String[] args) {
        ProjectFinal s = new ProjectFinal();
        GLProfile glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);
        caps.setDoubleBuffered(true);
        GLCanvas canvas = new GLCanvas(caps);
        canvas.addGLEventListener(s);
        JFrame frame = new JFrame("Animating triangle");
        frame.setSize(300, 300);
        frame.add(canvas);
        frame.setVisible(true);

        canvas.addGLEventListener(new ProjectFinal());
        animator = new Animator(canvas);
        animator.start();
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        theta = 0.001;
        beta = -0.001;
        GL2 gl = drawable.getGL().getGL2();

        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

        radius = 0.4;

        f0 = 0.6;
        g0 = 0.1;
        gl.glColor3d(1, 1, 1);

        gl.glBegin(GL2.GL_TRIANGLE_FAN);
        gl.glVertex2d(f0, g0);

        for (angle = 1.0; angle < 361; angle += 0.2) {
            f1 = f0 + Math.sin(angle) * radius;
            g1 = g0 + Math.cos(angle) * radius;
            gl.glVertex2d(f1, g1);
        }

        gl.glEnd();
        // draw a triangle filling the window
        gl.glColor3d(0.4, 0.6, 0.8);
        gl.glBegin(GL2.GL_QUADS);

        //Q4
        gl.glVertex3d(a0, b0, z);
        gl.glVertex3d(a2, b1, z);
        gl.glVertex3d(a2, b3, z);
        gl.glVertex3d(a0, b2, z);
        //Q5
        gl.glVertex3d(a2, b1, z);
        gl.glVertex3d(a3, b1, z);
        gl.glVertex3d(a3, b3, z);
        gl.glVertex3d(a2, b3, z);
        gl.glEnd();
        //Border
        gl.glBegin(GL2.GL_LINES);
        gl.glColor3d(0, 0, 0);
        gl.glVertex2d(a0, b2);
        gl.glVertex2d(a2, b3);
        gl.glVertex2d(a2, b3);
        gl.glVertex2d(a3, b3);
        gl.glEnd();
        //Circle
        radius = 0.25;

        f0 = 0.62;
        g0 = 0.24;
        gl.glColor3d(1, 0.8, 0);

        gl.glBegin(GL2.GL_TRIANGLE_FAN);
        gl.glVertex2d(f0, g0);

        for (angle = 1.0; angle < 361; angle += 0.2) {
            f1 = f0 + Math.sin(angle) * radius;
            g1 = g0 + Math.cos(angle) * radius;
            gl.glVertex2d(f1, g1);
        }

        gl.glEnd();
        //Eyeball 1
        radius = 0.025;

        f0 = 0.5;
        g0 = 0.27;
        gl.glColor3d(1, 1, 1);

        gl.glBegin(GL2.GL_TRIANGLE_FAN);
        gl.glVertex2d(f0, g0);

        for (angle = 1.0; angle < 361; angle += 0.2) {
            f1 = f0 + Math.sin(angle) * radius;
            g1 = g0 + Math.cos(angle) * radius;
            gl.glVertex2d(f1, g1);
        }

        gl.glEnd();

        //Eyeball 2
        radius = 0.025;

        f0 = 0.7;
        g0 = 0.27;
        gl.glColor3d(1, 1, 1);

        gl.glBegin(GL2.GL_TRIANGLE_FAN);
        gl.glVertex2d(f0, g0);

        for (angle = 1.0; angle < 361; angle += 0.2) {
            f1 = f0 + Math.sin(angle) * radius;
            g1 = g0 + Math.cos(angle) * radius;
            gl.glVertex2d(f1, g1);
        }

        gl.glEnd();
        gl.glColor3d(0.4, 0.6, 0.8);
        gl.glBegin(GL2.GL_QUADS);

        //Box1
        //Q1
        if (y0 <= 0.35 && flag == 0) {
            y0 += theta;
            System.out.println(y0);
            y1 += theta;
            y2 += theta;
            y3 += theta;
            y0 = Math.round(y0 * 1000) / 1000D;
            if (y0 == 0.351) {
                flag = 1;
                System.out.println("flag" + flag);
            }
        } else if (y0 >= 0.2 && flag == 1) {
            y0 += beta;
            y1 += beta;
            y2 += beta;
            y3 += beta;
            y0 = Math.round(y0 * 1000) / 1000D;
            System.out.println("y0" + y0);
            if (y0 == 0.199) {
                flag = 0;
                System.out.println("flag" + flag);
                y0 = 0.2;
                y1 = 0.4;
                y2 = 0.3;
                y3 = 0.5;
            }
        }
        gl.glVertex3d(x0, y0, z);
        gl.glVertex3d(x1, y0, z);
        gl.glVertex3d(x3, y1, z);
        gl.glVertex3d(x2, y1, z);
        //Q2
        gl.glVertex3d(x0, y0, z);
        gl.glVertex3d(x2, y1, z);
        gl.glVertex3d(x2, y3, z);
        gl.glVertex3d(x0, y2, z);
        //Q3
        gl.glVertex3d(x1, y2, z);
        gl.glVertex3d(x3, y3, z);
        gl.glVertex3d(x3, y1, z);
        gl.glVertex3d(x1, y0, z);
        //Q4
        gl.glVertex3d(x2, y1, z);
        gl.glVertex3d(x2, y3, z);
        gl.glVertex3d(x3, y3, z);
        gl.glVertex3d(x3, y1, z);
        //Q5
        gl.glVertex3d(x0, y0, z);
        gl.glVertex3d(x1, y0, z);
        gl.glVertex3d(x1, y2, z);
        gl.glVertex3d(x0, y2, z);
        //Q6
        gl.glVertex3d(x0, y2, z);
        gl.glVertex3d(x2, y3, z);
        gl.glVertex3d(x3, y3, z);
        gl.glVertex3d(x1, y2, z);
        gl.glEnd();

        //Border
        gl.glColor3d(0, 0, 0);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(x0, y0);
        gl.glVertex2d(x0, y2);
        gl.glVertex2d(x1, y0);
        gl.glVertex2d(x1, y2);
        gl.glVertex2d(x1, y2);
        gl.glVertex2d(x3, y3);
        gl.glVertex2d(x3, y1);
        gl.glVertex2d(x3, y3);
        gl.glEnd();
        //Box2
        //Q1
        gl.glColor3d(0.4, 0.6, 0.8);
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex3d(a0, b0, z);
        gl.glVertex3d(a1, b0, z);
        gl.glVertex3d(a1, b2, z);
        gl.glVertex3d(a0, b2, z);
        //Q2
        gl.glVertex3d(a0, b0, z);
        gl.glVertex3d(a1, b0, z);
        gl.glVertex3d(a3, b1, z);
        gl.glVertex3d(a2, b1, z);
        //Q3      
        gl.glVertex3d(a1, b0, z);
        gl.glVertex3d(a3, b1, z);
        gl.glVertex3d(a3, b3, z);
        gl.glVertex3d(a1, b2, z);

        //Q6
//        gl.glVertex3d(a0, b2, z);
//        gl.glVertex3d(a1, b2, z);
//        gl.glVertex3d(a3, b3, z);
//        gl.glVertex3d(a2, b3, z);
        if (d0 <= 0.45 && flag2 == 0) {
            d0 += theta;
            System.out.println("d0" + d0);
            d1 += theta;
            d2 += theta;
            d3 += theta;
            d4 += theta;
            d5 += theta;
            d0 = Math.round(d0 * 1000) / 1000D;
            if (d0 == 0.451) {
                flag2 = 1;

            }
        } else if (d0 >= 0.3 && flag2 == 1) {
            d0 += beta;
            d1 += beta;
            d2 += beta;
            d3 += beta;
            d4 += beta;
            d5 += beta;
            d0 = Math.round(d0 * 1000) / 1000D;
            System.out.println("d0" + d0);
            System.out.println("flag2 elseif");
            if (d0 == 0.299) {
                flag2 = 0;
                d0 = 0.3;
                d1 = 0.5;
                d2 = 0.6;
                d3 = 0.8;

            }
        }
        //Roof
        //Q1
        gl.glColor3d(1, 0.3, 0.3);
        gl.glBegin(GL2.GL_QUADS);

        gl.glVertex3d(c0, d0, z);
        gl.glVertex3d(c4, d2, z);
        gl.glVertex3d(c5, d3, z);
        gl.glVertex3d(c2, d1, z);
        gl.glEnd();
        gl.glColor3d(0, 0, 0);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(a0, b0);
        gl.glVertex2d(a1, b0);
        gl.glVertex2d(a0, b0);
        gl.glVertex2d(a0, b2);
        gl.glVertex2d(a1, b0);
        gl.glVertex2d(a1, b2);
        gl.glVertex2d(a0, b2);
        gl.glVertex2d(a1, b2);
        gl.glVertex2d(a1, b0);
        gl.glVertex2d(a3, b1);
        gl.glVertex2d(a3, b1);
        gl.glVertex2d(a3, b3);
        gl.glVertex2d(a3, b3);
        gl.glVertex2d(a1, b2);

        gl.glEnd();
        gl.glColor3d(0.4, 0.6, 0.8);
        gl.glBegin(GL2.GL_TRIANGLES);
        //T1

        gl.glVertex2d(c0, d0);
        gl.glVertex2d(c1, d0);
        gl.glVertex2d(c4, d2);
        //T2
        gl.glVertex2d(c2, d1);
        gl.glVertex2d(c3, d1);
        gl.glVertex2d(c5, d3);
        gl.glEnd();

        gl.glColor3d(1, 0.3, 0.3);
        gl.glBegin(GL2.GL_QUADS);

        //Q2
        gl.glVertex3d(c1, d0, z);
        gl.glVertex3d(c3, d1, z);
        gl.glVertex3d(c5, d3, z);
        gl.glVertex3d(c4, d2, z);
        gl.glEnd();
        //Border
        gl.glColor3d(0, 0, 0);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(c0, d0);
        gl.glVertex2d(c4, d2);
        gl.glVertex2d(c1, d0);
        gl.glVertex2d(c4, d2);
        gl.glVertex2d(c3, d1);
        gl.glVertex2d(c5, d3);
        gl.glEnd();
        //Door
        gl.glColor3d(0, 0.2, 0.8);
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex3d(0.47, -0.1, 0);
        gl.glVertex3d(0.53, -0.1, 0);
        gl.glVertex3d(0.53, 0.075, 0);
        gl.glVertex3d(0.47, 0.075, 0);
        gl.glEnd();
        gl.glColor3d(1, 1, 1);
        //Door Borders
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(0.5, -0.1);
        gl.glVertex2d(0.5, 0.075);
        gl.glVertex2d(0.47, -0.1);
        gl.glVertex2d(0.47, 0.075);
        gl.glVertex2d(0.5, -0.1);
        gl.glVertex2d(0.5, 0.075);
        gl.glVertex2d(0.47, 0.075);
        gl.glVertex2d(0.53, 0.075);
        gl.glEnd();

        //Window 1
        gl.glColor3d(0, 0.2, 0.8);
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex3d(0.73, 0.05, 0);
        gl.glVertex3d(0.76, 0.09, 0);
        gl.glVertex3d(0.76, 0.15, 0);
        gl.glVertex3d(0.73, 0.11, 0);
        gl.glEnd();
        gl.glColor3d(1, 1, 1);
        //Window1 Borders
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(0.73, 0.05);
        gl.glVertex2d(0.76, 0.09);
        gl.glVertex2d(0.76, 0.09);
        gl.glVertex2d(0.76, 0.15);
        gl.glVertex2d(0.76, 0.15);
        gl.glVertex2d(0.73, 0.11);
        gl.glVertex2d(0.73, 0.11);
        gl.glVertex2d(0.73, 0.05);
        gl.glEnd();

        //Window 2
        gl.glColor3d(0, 0.2, 0.8);
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex3d(0.84, 0.16, 0);
        gl.glVertex3d(0.87, 0.20, 0);
        gl.glVertex3d(0.87, 0.26, 0);
        gl.glVertex3d(0.84, 0.22, 0);
        gl.glEnd();
        gl.glColor3d(1, 1, 1);
        //Door Borders
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(0.84, 0.16);
        gl.glVertex2d(0.87, 0.20);
        gl.glVertex2d(0.87, 0.20);
        gl.glVertex2d(0.87, 0.26);
        gl.glVertex2d(0.87, 0.26);
        gl.glVertex2d(0.84, 0.22);
        gl.glVertex2d(0.84, 0.22);
        gl.glVertex2d(0.84, 0.16);
        gl.glEnd();

        gl.glColor3d(0, 0.2, 0.8);
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex3d(c6, d4, 0);
        gl.glVertex3d(c7, d4, 0);
        gl.glVertex3d(c7, d5, 0);
        gl.glVertex3d(c6, d5, 0);
        gl.glEnd();
        //Border
        gl.glColor3d(1, 1, 1);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(c6, d4);
        gl.glVertex2d(c7, d4);
        gl.glVertex2d(c7, d4);
        gl.glVertex2d(c7, d5);
        gl.glVertex2d(c7, d5);
        gl.glVertex2d(c6, d5);
        gl.glVertex2d(c6, d5);
        gl.glVertex2d(c6, d4);
        gl.glEnd();
    }

    public void dispose(GLAutoDrawable drawable) {

    }

    public void init(GLAutoDrawable drawable) {
        drawable.getGL().setSwapInterval(1);
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
    }

}
